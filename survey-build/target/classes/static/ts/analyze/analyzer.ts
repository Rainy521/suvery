/// <reference path="chart/chart.ts" />
/// <reference path="data/data.ts" />

namespace analyze {
    interface Component {
        run(element: HTMLDivElement, dataOptions, chartOptions);
    }

    class Analyzer {
        private components = {};

        private dataConfig = new data.Configs();
        private chartConfig = new chart.Configs();

        constructor() {
            this.register(data.Type.SQL, chart.Type.Metric, new SQLMetric());
            this.register(data.Type.SQL, chart.Type.Table, new SQLTable());
            this.register(data.Type.SQL, chart.Type.Bar, new SQLBar());
            this.register(data.Type.SQL, chart.Type.Pie, new SQLPie());
            this.register(data.Type.SQL, chart.Type.Map, new SQLMap());
        }

        get(dataType: string, chartType: string) {
            return this.components[dataType][chartType];
        }

        getDataTypes() {
            return Object.keys(this.components);
        }

        getChartTypes(dataType: string) {
            return Object.keys(this.components[dataType]);
        }

        getDataConfig(dataType: string): string {
            return this.dataConfig.get(data.Type[dataType]).get();
        }

        getChartConfig(chartType: string): string {
            return this.chartConfig.get(chart.Type[chartType]).get();
        }

        private register(dataType: data.Type, chartType: chart.Type, component: Component) {
            let dataTypeName = data.Type[dataType];
            let chartTypeName = chart.Type[chartType];

            if (!this.components[dataTypeName]) {
                this.components[dataTypeName] = {};
            }

            this.components[dataTypeName][chartTypeName] = component;
        }
    }

    export var analyzer: Analyzer;
    $(document).ready(function () {
        analyzer = new Analyzer();
    });

    class SQLMetric implements Component {
        run(element: HTMLDivElement, dataOptions: data.SQLOptions, chartOptions: chart.MetricOptions) {
            new data.SQL().query(dataOptions, (data) => {
                new chart.Metric().paint(element, chartOptions, data["rows"][0][0]);
            });
        }
    }

    class SQLTable implements Component {
        run(element: HTMLDivElement, dataOptions: data.SQLOptions, chartOptions: chart.ChartOptions) {
            new data.SQL().query(dataOptions, (data) => {
                new chart.Table().paint(element, chartOptions, data["heads"], data["rows"]);
            });
        }
    }

    class SQLBar implements Component {
        run(element: HTMLDivElement, dataOptions: data.SQLOptions, chartOptions: chart.BarOptions) {
            new data.SQL().query(dataOptions, (data) => {
                let rows = data.rows;
                let nameValues = [];
                for (let i in rows) {
                    nameValues.push({name: rows[i][1], value: rows[i][0]});
                }
                new chart.Bar().paint(element, chartOptions, nameValues.map(i => i.name), [''], [nameValues.map(i => i.value)]);
            });
        }
    }

    class SQLPie implements Component {
        run(element: HTMLDivElement, dataOptions: data.SQLOptions, chartOptions: chart.PieOptions) {
            new data.SQL().query(dataOptions, (data) => {
                let rows = data.rows;
                let nameValues = [];
                for (let i in rows) {
                    nameValues.push({name: rows[i][1], value: rows[i][0]});
                }
                new chart.Pie().paint(element, chartOptions, [''], [nameValues]);
            });
        }
    }

    class SQLMap implements Component {
            run(element: HTMLDivElement, dataOptions: data.SQLOptions, chartOptions: chart.MapOptions) {
            new data.SQL().query(dataOptions, (data) => {
                let rows = data.rows;
                let nameValues = [];
                for (let i in rows) {
                    nameValues.push({name: rows[i][0], value: rows[i][1]});
                }
                new chart.Map().paint(element, chartOptions, nameValues);
            });
        }
    }

    class ESQueryTable implements Component {
        run(element: HTMLDivElement, dataOptions: data.ESQueryOptions, chartOptions: chart.ChartOptions) {
            new data.ESQuery(dataOptions, (data) => {
                new chart.Table().paint(element, chartOptions, data["heads"], data["rows"]);
            }).run();
        }
    }

    class ESAggBar implements Component {
        run(element: HTMLDivElement, dataOptions: data.ESAggOptions, chartOptions: chart.BarOptions) {
            new data.ESAgg(dataOptions, (data) => {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            let names = [];
                            let nameValues = [];
                            for (let i in data) {
                                for (let termItem of data[i].value) {
                                    if (names.indexOf(termItem.name) == -1) {
                                        names.push(termItem.name);
                                        nameValues.push([]);
                                    }
                                }
                            }

                            for (let i in data) {
                                for (let j in names) {
                                    for (let item of data[i].value) {
                                        if (names[j] == item.name) {
                                            nameValues[j][i] = item.value;
                                        }
                                    }
                                }
                            }
                            new chart.Bar().paint(element, chartOptions, data.map(i => i.name), names, nameValues);
                        } else {
                            new chart.Bar().paint(element, chartOptions, data.map(i => i.name), [''], [data.map(i => i.value)]);
                        }
                    }
                } else {
                    new chart.Bar().paint(element, chartOptions, [''], [''], [[data]]);
                }
            }).run();
        }
    }

    class ESAggPie implements Component {
        run(element: HTMLDivElement, dataOptions: data.ESAggOptions, chartOptions: chart.PieOptions) {
            new data.ESAgg(dataOptions, (data) => {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            new chart.Pie().paint(element, chartOptions, data.map(i => i.name), data.map(i => i.value));
                        } else {
                            new chart.Pie().paint(element, chartOptions, [''], [data]);
                        }
                    }
                } else {
                    new chart.Pie().paint(element, chartOptions, [''], [[{ name: '', value: data }]]);
                }
            }).run();
        }
    }

    class ESAggMetic implements Component {
        run(element: HTMLDivElement, dataOptions: data.ESAggOptions, chartOptions: chart.MetricOptions) {
            new data.ESAgg(dataOptions, (data) => {
                if (data instanceof Array) {
                    new chart.Metric().paint(element, chartOptions, '不支持');
                } else {
                    new chart.Metric().paint(element, chartOptions, data);
                }
            }).run();
        }
    }

    class ESAggTable implements Component {
        run(element: HTMLDivElement, dataOptions: data.ESAggOptions, chartOptions: chart.ChartOptions) {
            new data.ESAgg(dataOptions, (data) => {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            let names = [];
                            let dateValues = [];
                            for (let i in data) {
                                for (let termItem of data[i].value) {
                                    if (names.indexOf(termItem.name) == -1) {
                                        names.push(termItem.name);
                                    }
                                }

                                dateValues.push([]);
                            }

                            for (let i in data) {
                                for (let j in names) {
                                     dateValues[i][j] = null;
                                    for (let item of data[i].value) {
                                        if (names[j] == item.name) {
                                            dateValues[i][j] = item.value;
                                        }
                                    }
                                }
                            }

                            new chart.Table().paint(element, chartOptions, ['', ...names], data.map((i, index) => [i.name, ...dateValues[index]]));
                        } else {
                            new chart.Table().paint(element, chartOptions, data.map(i => i.name), [data.map(i => i.value)]);
                        }
                    }
                } else {
                    new chart.Table().paint(element, chartOptions, [], [[data]]);
                }
            }).run();
        }
    }
}