namespace analyze {
    export namespace data {
        export interface SQLOptions {
            readonly sql: string;
        }

        export class SQLConfig {
            get() {
                return `<div class="form-group">
                                <label for="title" class="col-sm-3 control-label">SQL语句</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control" name="sql" required="required" placeholder="">
                                </div>
                            </div>`;
            }
        }

        export class SQL {
            query(options: SQLOptions, callback) {
                if (!options.sql) {
                    return;
                }

                $.ajax({
                    type: "POST",
                    url: '/sql',
                    contentType: "application/json",
                    data: options.sql,
                    success: function (data) {
                        callback(data);
                    }
                });
            }
        }
    }
}