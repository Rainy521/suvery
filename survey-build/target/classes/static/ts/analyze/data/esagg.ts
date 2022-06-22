/// <reference path="escomponent.ts" />

namespace analyze {
    export namespace data {
        export enum ESMetricType { count, max, min, avg, sum, value_count, cardinality }

        export interface ESAggOptions extends ESOptions {
            readonly dateInterval?: number;
            readonly dateUnit?: string;
            readonly dateFormat?: string;

            readonly termFields?: string;
            readonly termSizes?: string;
            readonly termOrder: string;

            readonly metricType: string;
            readonly metricField?: string;
        }

        export class ESAggConfig extends ESConfig {
            get() {
                return super.get() +
                    `
                          <div class="form-group">
                                <label class="col-sm-3 control-label">聚合间隔</label>
                                <div class="col-sm-9">
                                <input type="number" class="form-control" name="dateInterval" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">间隔单位</label>
                                <div class="col-sm-9">
                                <select class="form-control" name="dateUnit">
                                <option value="d">天</option>
                                <option value="h">时</option>
                                <option value="m">分</option>
                                <option value="w">周</option>
                                <option value="M">月</option>
                                <option value="y">年</option>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">日期格式</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control" name="dateFormat" value="YYYY-MM-DD HH:mm:ss" placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">聚合字段</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control esfields" name="termFields" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">聚合大小</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control esfields" name="termSizes" placeholder="大小以逗号分隔。默认为10">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">聚合顺序</label>
                                <div class="col-sm-9">
                                <select class="form-control" name="termOrder">
                                    <option value="desc">降序</option>
                                    <option value="asc">升序</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">指标</label>
                                <div class="col-sm-9">
                                <select class="form-control"  name="metricType">
                                    <option value="count">日志总量</option>
                                    <option value="max">指标字段最大值</option>
                                    <option value="min">指标字段最小值</option>
                                    <option value="avg">指标字段平均值</option>
                                    <option value="sum">指标字段总和</option>
                                    <option value="value_count">指标字段值的个数</option>
                                    <option value="cardinality">指标字段不同值的个数</option>
                                </select>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">指标字段</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control esfield" name="metricField" placeholder="">
                                </div>
                            </div>
                            `;
            }
        }

        export class ESAgg extends ESComponent<ESAggOptions> {
            private termFiledArray: string[];
            private termSizeArray: number[];

            constructor(options: ESAggOptions, callback) {
                super(options, callback);

                this.termFiledArray = this.options.termFields.split(',').map(t => t ? t.trim() : t).filter(t => { return t });

                if (this.options.termSizes) {
                    this.termSizeArray = this.options.termSizes.split(',').map(t => t ? t.trim() : t).map(t => Number(t));
                } else {
                    this.termSizeArray = [];
                }
            }

            protected generateAgg() {
                return this.generateDateHistogramAgg();
            }

            private generateDateHistogramAgg() {
                let agg = this.generateTermsAgg();

                if (!this.options.dateInterval) {
                    return agg;
                }

                let datehistogram = {};
                let dateRange = common.utils.getDateRange(this.options.dateRange);
                datehistogram[this.options.dateField] =
                    {
                        "date_histogram": {
                            "field": this.options.dateField,
                            "interval": (this.options.dateInterval + this.options.dateUnit),
                            "min_doc_count": 0,
                            "offset": "-8h",
                            "extended_bounds": { "min": dateRange[0].valueOf(), "max": (dateRange[1].valueOf() - 1) }
                        }
                    };
                if (agg) {
                    datehistogram[this.options.dateField]['aggs'] = agg;
                }

                return datehistogram;
            }

            private generateTermsAgg() {
                let agg = this.generateMetricAgg();

                if (this.termFiledArray == null) {
                    return agg;
                }

                for (let i = this.termFiledArray.length - 1; i >= 0; i--) {
                    let term = this.termFiledArray[i];

                    term = term.trim();

                    if (!term) {
                        continue;
                    }

                    let tmpAgg = {};
                    tmpAgg[term] = { "terms": { "field": term } };

                    let childAggs = agg;

                    if (childAggs) {
                        tmpAgg[term]["aggs"] = childAggs;
                    }

                    if (i == this.termFiledArray.length - 1) {
                        if (childAggs) {
                            tmpAgg[term]["terms"]["order"] = { "metric": this.options.termOrder }
                        } else {
                            tmpAgg[term]["terms"]["order"] = { "_count": this.options.termOrder }
                        }
                    }

                    tmpAgg[term]["terms"]["size"] = this.termSizeArray[i] ? this.termSizeArray[i] : 10;

                    agg = tmpAgg;
                }

                return agg;
            }

            private generateMetricAgg() {
                let agg = null;
                if (this.options.metricType != ESMetricType[ESMetricType.count]) {
                    agg = { "metric": {} };
                    agg.metric[this.options.metricType] = { "field": this.options.metricField };
                }

                return agg;
            }

            protected convert(data) {
                let aggregations = data.aggregations;

                if (!aggregations) {
                    return data.hits.total;
                }

                if (this.options.dateInterval) {
                    return this.getDataHistogram(aggregations);
                } else if (this.termFiledArray.length > 0) {
                    return this.getTerm(aggregations);
                } else {
                    return this.getMetric(aggregations);
                }
            }

            private getDataHistogram(aggregations) {
                let dataHistogram = aggregations[this.options.dateField];

                let dataHistogramItems = [];

                dataHistogram.buckets.forEach(item => {
                    let dataHistogramItem = {};
                    dataHistogramItem['name'] = moment(item.key).format(this.options.dateFormat);

                    if (this.termFiledArray.length > 0) {
                        dataHistogramItem['value'] = this.getTerm(item);
                    } else {
                        dataHistogramItem['value'] = [{ name: '', value: this.getMetric(item) }];
                    }

                    dataHistogramItems.push(dataHistogramItem);
                });

                return dataHistogramItems;
            }

            private getTerm(termData, index = 0) {
                if (index < this.termFiledArray.length) {
                    let termFiled = this.termFiledArray[index];
                    let data = termData[termFiled];
                    if (data) {
                        let items = [];
                        data.buckets.forEach(bucket => {
                            let item = {};
                            let value;
                            if (index == this.termFiledArray.length - 1) {
                                value = this.getMetric(bucket);
                            } else {
                                value = this.getTerm(bucket, index + 1);
                            }
                            item = {
                                name: bucket.key,
                                value: value
                            }

                            items.push(item);
                        });

                        if (items.length > 0 && items[0].value instanceof Array) {
                            let flatItems = [];
                            for (let i in items) {
                                let name = items[i].name;

                                for (let j in items[i].value) {
                                    flatItems.push({
                                        name: name + '-' + items[i].value[j].name,
                                        value: items[i].value[j].value
                                    });
                                }
                            }

                            if (data.sum_other_doc_count > 0 && this.options.metricType == ESMetricType[ESMetricType.count]) {
                                flatItems.push({
                                    name: '其他',
                                    value: data.sum_other_doc_count
                                });
                            }

                            return flatItems;
                        } else {
                            if (data.sum_other_doc_count > 0 && this.options.metricType == ESMetricType[ESMetricType.count]) {
                                items.push({
                                    name: '其他',
                                    value: data.sum_other_doc_count
                                });
                            }

                            return items;
                        }
                    }
                }

                return [];
            }

            private getMetric(metricData) {
                let value;
                if (metricData.metric) {
                    value = metricData.metric.value;
                } else {
                    value = metricData.doc_count;
                }

                return value;
            }
        }
    }
}