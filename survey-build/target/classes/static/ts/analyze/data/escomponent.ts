/// <reference path="es.ts" />

namespace analyze {
    export namespace data {
        export abstract class ESComponent<T extends ESOptions> {
            protected options: T;
            protected callback;

            constructor(options: T, callback) {
                this.options = options;
                this.callback = callback;
            }

            run() {
                this.options = $.extend({}, {
                    type: '_all',
                    q: '',
                    dateField: 'timestamp'
                }, this.options);

                let agg = this.generateAgg();

                new ES().search(this.options, agg, (data) => {
                    let value = this.convert(data);
                    this.callback(value);
                });
            }

            protected generateAgg() {
                return null;
            }

            protected convert(data) {
                return data;
            }

        }
    }
}