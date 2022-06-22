namespace page {
    export namespace dashboard {
        export namespace dashboard {

            export function init() {
                let id = common.utils.getParameterByName('id', null);
                if (id) {
                    page.dashboard.layout.loadLayout(id);
                } else {
                    let layouts = $('#layouts');
                    layouts.show();
                    page.dashboard.layout.loadLayouts(true);
                    layouts.on('change', function () {
                        page.dashboard.layout.loadLayout(layouts.val());
                    })
                }
            }
        }
    }
}
