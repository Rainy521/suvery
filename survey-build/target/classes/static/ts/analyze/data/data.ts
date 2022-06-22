/// <reference path="sql.ts" />
/// <reference path="esquery.ts" />
/// <reference path="esagg.ts" />

namespace analyze {
    export namespace data {
        export enum Type { SQL };

        export class Configs {
            configs = {};

            constructor() {
                this.configs[Type.SQL] = new SQLConfig();
            }

            get(type: Type) {
                return this.configs[type];
            }

            getAll() {
                return this.configs;
            }
        }
    }
}