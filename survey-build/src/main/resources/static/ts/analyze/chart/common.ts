namespace analyze {
    export namespace chart {
        export interface ChartOptions {
            readonly title: string;
        }

        export class ChartConfig {
            get() {
                return `<div class="form-group">
                                <label class="col-sm-3 control-label">标题</label>
                                <div class="col-sm-9">
                                <input type="text" class="form-control" name="title" required="required" placeholder="">
                                </div>
                            </div>`;
            }
        }
    }
}