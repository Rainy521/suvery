/// <reference path="escomponent.ts" />

namespace analyze {
    export namespace data {

        export interface ESQueryOptions extends ESOptions {
            readonly fields: string;
        }

        export class ESQueryConfig extends ESConfig {
            get() {
                return super.get() +
                          ` <div class="form-group">
                                <label class="col-sm-3 control-label">列</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control esfields" name="fields" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">显示条数</label>
                                <div class="col-sm-9">
                                <input type="number" class="form-control" name="pageSize" placeholder="">
                                </div>
                            </div>`;
            }
        }

        export class ESQuery extends ESComponent<ESQueryOptions> {
            constructor(options: ESQueryOptions, callback) {
                super(options, callback);
            }

            protected convert(data) {
                var heads = this.options.fields.split(',').map(f => f.trim()).filter(f => f);
                var bodys = [];
                var array = [];
                data.hits.hits.forEach(hits => {
                    var body = [];
                    heads.forEach(head => {
                        body.push(hits._source[head]);
                    });
                    bodys.push(body);
                });
                
                array["heads"] = heads;
                array["rows"] = bodys;

                return array;
            }
        }
    }
}