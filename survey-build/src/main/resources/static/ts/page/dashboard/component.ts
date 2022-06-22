namespace page {
    export namespace dashboard {
        export namespace component {
            let config: any = {};

            function saveConfig() {
                let dataConfig = $('#dataConfigForm').serializeObject()
                let chartConfig = $('#chartConfigForm').serializeObject();
                config = { data: dataConfig, chart: chartConfig };
            };

            function initDataConfigVal() {
                for (let name in config.data) {
                    if (name != 'dataType') {
                        $(`#dataConfigForm [name="${name}"]`).val(config.data[name]);
                    }
                }
            }

            function initChartConfigVal() {
                for (let name in config.chart) {
                    if (name != 'chartType') {
                        $(`#chartConfigForm [name="${name}"]`).val(config.chart[name]);
                    }
                }
            }

            export function init() {
                let analyzer = analyze.analyzer;
                let dataType = $('#dataType');
                let chartType = $('#chartType');

                let configStr = common.utils.getParameterByName('config', null);
                if (configStr) {
                    config = JSON.parse(configStr);
                }

                dataType.html(analyzer.getDataTypes().map(type => `<option vlaue="${type}">${type}</option>`).join(''));

                if (config.data) {
                    dataType.val(config.data.dataType);
                }
                $('#dataConfigs').html(analyzer.getDataConfig(dataType.val()));
                if (config.data) {
                    initDataConfigVal();
                }

                chartType.html(analyzer.getChartTypes(dataType.val()).map(type => `<option vlaue="${type}">${type}</option>`).join(''));

                if (config.chart) {
                    chartType.val(config.chart.chartType);
                }
                $('#chartConfigs').html(analyzer.getChartConfig(chartType.val()));
                if (config.chart) {
                    initChartConfigVal();
                }

                dataType.on("change", (event) => {
                    saveConfig();

                    $('#dataConfigs').html(analyzer.getDataConfig(dataType.val()));

                    initDataConfigVal();

                    chartType.html(analyzer.getChartTypes(dataType.val()).map(type => `<option vlaue="${type}">${type}</option>`).join(''));

                    if (analyzer.getChartTypes(dataType.val()).indexOf(config.chart.chartType) == -1) {
                        chartType.change();
                    } else {
                        chartType.val(config.chart.chartType);
                    }
                });

                chartType.on("change", (event) => {
                    saveConfig();

                    $('#chartConfigs').html(analyzer.getChartConfig(chartType.val()));
                    initChartConfigVal();
                });

                $('#preview').on("click", (event) => {
                    saveConfig();
                    analyzer.get(config.data.dataType, config.chart.chartType).run(document.getElementById("chart"), config.data, config.chart);
                });

                $('#save').on("click", (event) => {
                    saveConfig();

                    let selected = parent['$'](".selected");
                    selected.attr("data-config", JSON.stringify(config));

                    let index = parent['layer'].getFrameIndex(window.name);
                    parent['layer'].close(index);
                });
            }
        }
    }
}