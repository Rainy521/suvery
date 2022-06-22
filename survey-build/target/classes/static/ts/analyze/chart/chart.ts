/// <reference path="echart.ts" />
/// <reference path="metric.ts" />
/// <reference path="table.ts" />

namespace analyze {
    export namespace chart {
        export enum Type { Metric, Table, Pie, Bar, Map };

        export class Configs {
            configs = {};

            constructor() {
                this.configs[Type.Metric] = new MetricConfig();
                this.configs[Type.Table] = new ChartConfig();
                this.configs[Type.Pie] = new PieConfig();
                this.configs[Type.Bar] = new BarConfig();
                this.configs[Type.Map] = new MapConfig();
            }

            get(type: Type) {
                return this.configs[type];
            }
        }
    }
}