namespace analyze {
    export namespace data {
        export interface ESOptions {
            readonly index: string;
            readonly type: string;
            readonly q?: string;
            readonly dateRange: string;
            readonly dateField: string;
            readonly pageSize?: number;
        }

        export class ESConfig {
            get() {
                return `<div class="form-group">
                                <label for="index" class="col-sm-3 control-label">索引</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control esindex" name="index"  required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="index" class="col-sm-3 control-label">ES查询语句</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control" name="q">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">时间区间</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="dateRange">
                                        <option value="today">今天</option>
                                        <option value="yesterday">昨天</option>
                                        <option value="week">本周</option>
                                        <option value="month">本月</option>
                                        <option value="year">今年</option>
                                    </select>
                                </div>
                            </div>
                             <div class="form-group">
                                <label for="index" class="col-sm-3 control-label">时间字段</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control" name="dateField" value="timestamp" required="required">
                                </div>
                            </div>`;
            }
        }

        export class ES {
            search(options: ESOptions, agg: object, callback) {
                let [startDate, endDate] = common.utils.getDateRange(options.dateRange);

                if (!(options.index && options.type && startDate && endDate)) {
                    return;
                }

                let q = options.q + this.getDateRangeCondition(startDate, endDate, options.dateField);
                var url = `/search/${options.index}/${options.type}?q=${encodeURIComponent(q)}`;

                if (agg) {
                    url += '&agg=' + encodeURIComponent(JSON.stringify(agg));
                }
                if(options.pageSize){
                    url += '&pageSize=' + options.pageSize;
                }

                $.get(url).done(function (data) {
                    callback(data);
                });
            }

            private getDateRangeCondition(startDate: moment.Moment, endDate: moment.Moment, dateField: string) {
                return ` +${dateField}:["${startDate.utc().format("YYYY-MM-DD HH:mm:ss")}" TO "${endDate.utc().format("YYYY-MM-DD HH:mm:ss")}"}`;
            }
        }
    }
}