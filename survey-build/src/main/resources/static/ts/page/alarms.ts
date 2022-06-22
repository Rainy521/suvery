namespace page {
    export namespace alarms {
        declare var INDEX;

        export function init() {
            load();
            setInterval(load, 1 * 60 * 1000);
        }

        type RangeMetric = {
            metricTime: number, c0: string, c1: string, c2: string, c3: string, c4: string, c5: string, c6: string, c7: string, updateTime: number
        }

        function getErrorKey(r: RangeMetric): string {
            return r.c2 + '-' + r.c3 + '-' + r.c4;
        }

        function compare(errorRangeMetric: RangeMetric, lastErrorRangeMetric: RangeMetric): boolean {
            if (lastErrorRangeMetric) {
                if ((parseFloat(errorRangeMetric.c6) - parseFloat(lastErrorRangeMetric.c6) > 10
                    || parseInt(errorRangeMetric.c5) / parseInt(lastErrorRangeMetric.c5) > 1.5)
                    && (parseInt(errorRangeMetric.c5) - parseInt(lastErrorRangeMetric.c5)) > 100) {
                    return true;
                }
            } else {
                if (parseFloat(errorRangeMetric.c6) > 5 && parseInt(errorRangeMetric.c5) > 100) {
                    return true;
                }
            }

            return false;
        }

        function load() {
            let errors = $('#errors');
            errors.empty();
            $.get(`/rangemetrics/last?c=${INDEX}%2Cerror`).done((rangeMetrics: RangeMetric[]) => {
                if (rangeMetrics.length == 0) {
                    return;
                }

                let actions = rangeMetrics.map(r => r.c2);
                let funcs = rangeMetrics.map(r => r.c3);

                let metricTime = rangeMetrics[0].metricTime;
                $.get(`/utils/lastsametypeday?date=${metricTime}&size=3`)
                    .done((dates: number[]) => {
                        let oldDates = [metricTime - 5 * 60 * 1000, ...dates];
                        $.get(`/rangemetrics?metricTimes=${oldDates}&c=${INDEX}%2Cerror`)
                            .done((oldRangeMetrics) => {
                                Object.keys(oldRangeMetrics).forEach(t => {
                                    let rs: RangeMetric[] = oldRangeMetrics[t];
                                    let ro = {};
                                    rs.forEach(r => {
                                        ro[getErrorKey(r)] = r;
                                    });

                                    oldRangeMetrics[t] = ro;
                                });

                                common.utils.convertCode('1', actions, (actionMap) => {
                                    common.utils.convertCode('2', funcs, (funcMap) => {
                                        let table = `<table class="table table-bordered">
                                                <thead>
                                                <tr>
                                                    <td colspan="3"></td> <td colspan="2">${moment(metricTime).format('MM-DD HH:mm')}</td>${oldDates.map(d => `<td colspan="2">${moment(d).format('MM-DD HH:mm')}`).join('')}
                                                </tr>
                                                <tr>
                                                    <td>请求号</td> <td>功能号</td> <td>错误号</td><td>错误数</td> <td>错误比例</td>${oldDates.map(d => '<td>错误数</td> <td>错误比例</td>').join('')}
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    ${rangeMetrics.map(r => {
                                                let key = getErrorKey(r);

                                                let isDanger = compare(r, oldRangeMetrics[oldDates[0]][key]) && compare(r, oldRangeMetrics[oldDates[1]][key]);

                                                let row = `<tr class="${isDanger ? 'danger' : ''}"><td>${r.c2}${actionMap[r.c2]}</td><td>${r.c3}${funcMap[r.c3]}</td><td>${r.c4}</td><td>${r.c5}</td><td>${r.c6}%</td>`;
                                                for (let t of oldDates) {
                                                    let oldRangeMetric = oldRangeMetrics[t][key];
                                                    if (oldRangeMetric) {
                                                        row += `<td>${oldRangeMetric.c5}</td><td>${oldRangeMetric.c6}%</td>`;
                                                    } else {
                                                        row += `<td></td><td></td>`;
                                                    }
                                                }
                                                return row;
                                            }).join('')}
                                                </tbody>
                                            </table>`;
                                        errors.append(table);
                                    });
                                });
                            });
                    });
            });
        }
    }
}
