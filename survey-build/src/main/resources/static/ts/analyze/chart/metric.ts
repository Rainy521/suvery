/// <reference path="common.ts" />

namespace analyze {
    export namespace chart {
        export interface MetricOptions extends ChartOptions{
            readonly precision: number;
        }

        export class MetricConfig extends ChartConfig{
            get() {
                return super.get() + 
                            `<div class="form-group">
                                <label for="title" class="col-sm-3 control-label">显示精度</label>
                                <div class="col-sm-9">
                                <input type="number" class="form-control" name="precision" required="required" placeholder="">
                                </div>
                            </div>`;
            }
        }

        export class Metric {
            paint(element: HTMLDivElement, options: MetricOptions, value: string) {
                if (options.precision) {
                    let n = parseFloat(value);
                    value = n.toFixed(options.precision);
                }

                let chart = `<div class="ibox">
                                    <div class="ibox-content">
                                        <h5>${options.title}</h5>
                                        <h2>${value}</h2>
                                    </div>
                                </div>`;
                element.innerHTML = chart;
            }
        }
    }
}