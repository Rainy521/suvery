namespace common {
    export namespace utils {
        export let maxPageSize = 2147483647;

        export function getParameterByName(name: string, url: string): string {
            if (!url) url = window.location.href;
            name = name.replace(/[\[\]]/g, "\\$&");
            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                results = regex.exec(url);
            if (!results) return null;
            if (!results[2]) return '';
            return decodeURIComponent(results[2].replace(/\+/g, " "));
        }

        export function getDateRange(dateRange: string){
            let startDate: moment.Moment, endDate: moment.Moment;
            switch (dateRange) {
                case 'today':
                    startDate = moment().startOf('day');
                    endDate = moment().startOf('day').add(1, 'days');
                    break;
                case 'yesterday':
                    startDate = moment().startOf('day').subtract(1, 'days');
                    endDate = moment().startOf('day');
                    break;
                case 'week':
                    startDate = moment().startOf('week');
                    endDate = moment().startOf('day').add(1, 'days');
                    break;
                case 'month':
                    startDate = moment().startOf('month');
                    endDate = moment().startOf('day').add(1, 'days');
                    break;
                case 'year':
                    startDate = moment().startOf('year');
                    endDate = moment().startOf('day').add(1, 'days');
                    break;
            }

            return [startDate, endDate];
        }

        export function decimalFormat(value) {
            if (value == undefined || value == null) {
                return 0;
            }
            
            var strValue = value.toString();
            
            if (strValue.indexOf('.') != -1) {
                if ((value > 0 && value < 0.01) || (value < 0 && value > -0.01)) {
                    return "0.00";
                }
                
                return parseFloat(strValue).toFixed(2);
            } else {
                return value;
            }
        }

        export function convertCode(codeType : string, codes : string[], callback) {
            if (codeType) {
                 $.get('/code/get?type=' + codeType + '&codes=' + codes).done(callback);
            } else {
                callback({});
            }
        }
    }
}