var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var analyze;
(function (analyze) {
    var chart;
    (function (chart) {
        var ChartConfig = (function () {
            function ChartConfig() {
            }
            ChartConfig.prototype.get = function () {
                return "<div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u6807\u9898</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control\" name=\"title\" required=\"required\" placeholder=\"\">\n                                </div>\n                            </div>";
            };
            return ChartConfig;
        }());
        chart.ChartConfig = ChartConfig;
    })(chart = analyze.chart || (analyze.chart = {}));
})(analyze || (analyze = {}));
/// <reference path="common.ts" />
var analyze;
(function (analyze) {
    var chart;
    (function (chart_1) {
        var ESConfig = (function (_super) {
            __extends(ESConfig, _super);
            function ESConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            ESConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "<div class=\"form-group\">\n                        <label class=\"col-sm-3 control-label\">\u56FE\u50CF\u9AD8\u5EA6</label>\n                        <div class=\"col-sm-9\">\n                        <input type=\"text\" class=\"form-control\" name=\"height\" placeholder=\"\">\n                        </div>\n                    </div>\n                    <div class=\"form-group\">\n                        <label class=\"col-sm-3 control-label\">\u6807\u5FD7\u56FE\u5F62</label>\n                        <div class=\"col-sm-4\">\n                            <select class=\"form-control\" name=\"legendShow\">\n                                <option value=\"true\">\u663E\u793A\u9ED8\u8BA4</option>\n                                <option value=\"false\">\u4E0D\u663E\u793A</option>\n                            </select>\n                        </div>\n                            <div class=\"col-sm-4\">\n                            <select class=\"form-control\" name=\"legendOrient\">\n                                <option value=\"horizontal\">\u6C34\u5E73\u671D\u5411</option>\n                                <option value=\"vertical\">\u5782\u76F4\u671D\u5411</option>\n                            </select>\n                        </div>\n                        <div class=\"col-sm-offset-3 col-sm-4\">\n                            <select class=\"form-control\" name=\"legendLeft\">\n                                <option value=\"auto\">\u6C34\u5E73\u9ED8\u8BA4</option>\n                                <option value=\"left\">\u6C34\u5E73\u5DE6</option>\n                                <option value=\"center\">\u6C34\u5E73\u4E2D</option>\n                                <option value=\"right\">\u6C34\u5E73\u4E0B</option>\n                            </select>\n                        </div>\n                            <div class=\"col-sm-4\">\n                            <select class=\"form-control\" name=\"legendTop\">\n                                <option value=\"auto\">\u5782\u76F4\u9ED8\u8BA4</option>\n                                <option value=\"top\">\u5782\u76F4\u4E0A</option>\n                                <option value=\"middle\">\u5782\u76F4\u4E2D</option>\n                                <option value=\"bottom\">\u5782\u76F4\u4E0B</option>\n                            </select>\n                        </div>\n                    </div>";
            };
            return ESConfig;
        }(chart_1.ChartConfig));
        var Echart = (function () {
            function Echart() {
            }
            Echart.prototype.paint = function (element, chartOptions, options) {
                var chart = "<div class=\"ibox\">\n                                    <div class=\"ibox-title\">\n                                        <h5>" + chartOptions.title + "</h5>\n                                    </div>\n                                    <div class=\"ibox-content\">\n                                        <div class=\"echart\" style=\"height: 100%\"></div>\n                                    </div>\n                                 </div>";
                element.innerHTML = chart;
                var $content = $(element.getElementsByClassName('ibox-content'));
                if (chartOptions.height) {
                    $content.height(chartOptions.height);
                }
                else {
                    var width = $content.width();
                    if (width > 400) {
                        $content.height(400);
                    }
                    else {
                        $content.height(width);
                    }
                }
                var myChart = echarts.init(element.querySelector(".echart"));
                var customOptions = { legend: {} };
                customOptions.legend.show = chartOptions.legendShow == 'true';
                customOptions.legend.orient = chartOptions.legendOrient;
                customOptions.legend.left = chartOptions.legendLeft;
                customOptions.legend.top = chartOptions.legendTop;
                myChart.setOption(options, true, true);
                myChart.setOption(customOptions);
                if (chartOptions['polling'] == 'true') {
                    var index = 1;
                    setInterval(function () {
                        var op = myChart.getOption();
                        var data = op.series[0].data;
                        myChart.dispatchAction({
                            type: 'showTip',
                            seriesIndex: 0,
                            dataIndex: index
                        });
                        index++;
                        if (data.length < index) {
                            myChart.setOption(op);
                            index = 0;
                        }
                    }, 3000);
                }
                $(window).resize(function () {
                    myChart.resize();
                });
            };
            return Echart;
        }());
        chart_1.Echart = Echart;
        var PieConfig = (function (_super) {
            __extends(PieConfig, _super);
            function PieConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            PieConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "<div class=\"form-group\">\n                        <label class=\"col-sm-3 control-label\">\u7F16\u7801\u7C7B\u578B</label>\n                        <div class=\"col-sm-9\">\n                        <input type=\"text\" class=\"form-control\" name=\"codeType\" placeholder=\"\">\n                        </div>\n                    </div>";
            };
            return PieConfig;
        }(ESConfig));
        chart_1.PieConfig = PieConfig;
        var Pie = (function () {
            function Pie() {
            }
            Pie.prototype.paint = function (element, chartOptions, keys, datas) {
                var names = {};
                datas.forEach(function (d) {
                    d.forEach(function (i) {
                        names[i.name] = true;
                    });
                });
                common.utils.convertCode(chartOptions.codeType, Object.keys(names), function (nameMap) {
                    datas.forEach(function (d) {
                        d.forEach(function (i) {
                            var convertName = nameMap[i.name];
                            if (convertName) {
                                i.name = convertName;
                            }
                        });
                    });
                    var seriesData = [];
                    for (var i = 0; i < datas.length; i++) {
                        seriesData[i] = {
                            type: 'pie',
                            name: keys[i],
                            data: datas[i]
                        };
                    }
                    if (seriesData.length > 1) {
                        for (var i = 0; i < datas.length; i++) {
                            seriesData[i]['radius'] = [(20 + 70 / datas.length * i) + '%', (20 + 70 / datas.length * (i + 0.6)) + '%'];
                        }
                    }
                    var echart = new chart.Echart();
                    echart.paint(element, chartOptions, {
                        tooltip: {
                            formatter: "{a} {b}: {c} ({d}%)",
                        },
                        legend: {
                            data: keys
                        },
                        series: seriesData
                    });
                });
            };
            return Pie;
        }());
        chart_1.Pie = Pie;
        var BarConfig = (function (_super) {
            __extends(BarConfig, _super);
            function BarConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            BarConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "<div class=\"form-group\">\n                        <label for=\"stack\" class=\"col-sm-3 control-label\">\u5806\u6808\u663E\u793A</label>\n                        <div class=\"col-sm-9\">\n                        <select class=\"form-control\" name=\"stack\">\n                        <option value=\"true\">\u662F</option>\n                        <option value=\"\">\u5426</option>\n                        </select>\n                        </div>\n                    </div>";
            };
            return BarConfig;
        }(ESConfig));
        chart_1.BarConfig = BarConfig;
        var Bar = (function () {
            function Bar() {
            }
            Bar.prototype.paint = function (element, barOptions, xValues, legends, datas) {
                var echart = new chart.Echart();
                var seriesData = [];
                for (var i = 0; i < datas.length; i++) {
                    seriesData[i] = {
                        type: 'bar',
                        stack: barOptions.stack,
                        name: legends[i],
                        data: datas[i]
                    };
                }
                echart.paint(element, barOptions, {
                    barMaxWidth: "30px",
                    grid: {
                        left: 'left',
                        top: legends[0] ? 40 : 8,
                        right: 0,
                        bottom: 0,
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        },
                        confine: true
                    },
                    legend: {
                        data: legends
                    },
                    xAxis: {
                        data: xValues
                    },
                    yAxis: {},
                    series: seriesData
                });
            };
            return Bar;
        }());
        chart_1.Bar = Bar;
        var MapConfig = (function (_super) {
            __extends(MapConfig, _super);
            function MapConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            MapConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "<div class=\"form-group\">\n                        <label for=\"area\" class=\"col-sm-3 control-label\">\u533A\u57DF</label>\n                        <div class=\"col-sm-9\">\n                        <select class=\"form-control\" name=\"area\">\n                        <option value=\"china\">\u5168\u56FD</option>\n                        <option value=\"xiamen\">\u672C\u5E02</option>\n                        <option value=\"fujian\">\u798F\u5EFA</option>\n                        </select>\n                        </div>\n                    </div>\n                    <div class=\"form-group\">\n                        <label for=\"polling\" class=\"col-sm-3 control-label\">\u662F\u5426\u8F6E\u8BE2</label>\n                        <div class=\"col-sm-9\">\n                        <select class=\"form-control\" name=\"polling\">\n                        <option value=\"true\">\u662F</option>\n                        <option value=\"false\">\u5426</option>\n                        </select>\n                        </div>\n                    </div>\n                    <div class=\"form-group\">\n                        <label for=\"low\" class=\"col-sm-3 control-label\">\u7EDF\u8BA1\u8303\u56F4</label>\n                        <div class=\"col-sm-4\">\n                        <input class=\"form-control\" readOnly=\"true\" name=\"low\" type=\"number\" min=\"0\" value=\"0\">\n                        </div>\n                        <label for=\"high\" class=\"col-sm-1 control-label\">\u81F3</label>\n                        <div class=\"col-sm-4\">\n                        <input class=\"form-control\" name=\"high\" type=\"number\" min=\"0\">\n                        </div>\n                    </div>";
            };
            return MapConfig;
        }(ESConfig));
        chart_1.MapConfig = MapConfig;
        var Map = (function () {
            function Map() {
            }
            Map.prototype.paint = function (element, mapOptions, datas) {
                var echart = new chart.Echart();
                $.get('/json/map/' + mapOptions.area + '.json', function (json) {
                    echarts.registerMap(mapOptions.area, json);
                    var seriesData = [];
                    seriesData[0] = {
                        name: mapOptions.title,
                        type: 'map',
                        mapType: mapOptions.area,
                        itemStyle: {
                            normal: { label: { show: true } },
                            emphasis: {
                                label: { show: true },
                                areaColor: '#3be2fb',
                                color: '#000000',
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        data: datas
                    };
                    echart.paint(element, mapOptions, {
                        tooltip: {
                            trigger: 'item',
                            position: function (point, params, dom, rect, size) {
                                return ['85%', '10%'];
                            }
                        },
                        visualMap: {
                            min: mapOptions.low,
                            max: mapOptions.high,
                            text: ['高', '低'],
                            realtime: false,
                            calculable: true,
                            inRange: {
                                color: ['lightskyblue', 'yellow', 'orangered']
                            }
                        },
                        series: seriesData
                    });
                });
            };
            return Map;
        }());
        chart_1.Map = Map;
    })(chart = analyze.chart || (analyze.chart = {}));
})(analyze || (analyze = {}));
/// <reference path="common.ts" />
var analyze;
(function (analyze) {
    var chart;
    (function (chart_2) {
        var MetricConfig = (function (_super) {
            __extends(MetricConfig, _super);
            function MetricConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            MetricConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "<div class=\"form-group\">\n                                <label for=\"title\" class=\"col-sm-3 control-label\">\u663E\u793A\u7CBE\u5EA6</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"number\" class=\"form-control\" name=\"precision\" required=\"required\" placeholder=\"\">\n                                </div>\n                            </div>";
            };
            return MetricConfig;
        }(chart_2.ChartConfig));
        chart_2.MetricConfig = MetricConfig;
        var Metric = (function () {
            function Metric() {
            }
            Metric.prototype.paint = function (element, options, value) {
                if (options.precision) {
                    var n = parseFloat(value);
                    value = n.toFixed(options.precision);
                }
                var chart = "<div class=\"ibox\">\n                                    <div class=\"ibox-content\">\n                                        <h5>" + options.title + "</h5>\n                                        <h2>" + value + "</h2>\n                                    </div>\n                                </div>";
                element.innerHTML = chart;
            };
            return Metric;
        }());
        chart_2.Metric = Metric;
    })(chart = analyze.chart || (analyze.chart = {}));
})(analyze || (analyze = {}));
/// <reference path="common.ts" />
var analyze;
(function (analyze) {
    var chart;
    (function (chart_3) {
        var Table = (function () {
            function Table() {
            }
            Table.prototype.paint = function (element, options, head, body) {
                var chart = "<div class=\"ibox float-e-margins\">\n                                <div class=\"ibox-title\">\n                                    <h5>" + options.title + "</h5>\n                                </div>\n                                <div class=\"ibox-content\">\n                                    <table class=\"table table-bordered \">\n                                        <thead>\n                                        <tr>\n                                            " + head.map(function (h) { return "<th>" + (h ? h : '') + "</th>"; }).join('') + "\n                                        </tr>\n                                        </thead>\n                                        <tbody>\n                                            " + body.map(function (r) { return "<tr>" + r.map(function (d) { return "<td>" + (d ? d : '') + "</td>"; }).join('') + "</tr>"; }).join('') + "\n                                        </tbody>\n                                    </table>\n                                </div>\n                            </div>";
                element.innerHTML = chart;
            };
            return Table;
        }());
        chart_3.Table = Table;
    })(chart = analyze.chart || (analyze.chart = {}));
})(analyze || (analyze = {}));
/// <reference path="echart.ts" />
/// <reference path="metric.ts" />
/// <reference path="table.ts" />
var analyze;
(function (analyze) {
    var chart;
    (function (chart) {
        var Type;
        (function (Type) {
            Type[Type["Metric"] = 0] = "Metric";
            Type[Type["Table"] = 1] = "Table";
            Type[Type["Pie"] = 2] = "Pie";
            Type[Type["Bar"] = 3] = "Bar";
            Type[Type["Map"] = 4] = "Map";
        })(Type = chart.Type || (chart.Type = {}));
        ;
        var Configs = (function () {
            function Configs() {
                this.configs = {};
                this.configs[Type.Metric] = new chart.MetricConfig();
                this.configs[Type.Table] = new chart.ChartConfig();
                this.configs[Type.Pie] = new chart.PieConfig();
                this.configs[Type.Bar] = new chart.BarConfig();
                this.configs[Type.Map] = new chart.MapConfig();
            }
            Configs.prototype.get = function (type) {
                return this.configs[type];
            };
            return Configs;
        }());
        chart.Configs = Configs;
    })(chart = analyze.chart || (analyze.chart = {}));
})(analyze || (analyze = {}));
var analyze;
(function (analyze) {
    var data;
    (function (data_1) {
        var SQLConfig = (function () {
            function SQLConfig() {
            }
            SQLConfig.prototype.get = function () {
                return "<div class=\"form-group\">\n                                <label for=\"title\" class=\"col-sm-3 control-label\">SQL\u8BED\u53E5</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control\" name=\"sql\" required=\"required\" placeholder=\"\">\n                                </div>\n                            </div>";
            };
            return SQLConfig;
        }());
        data_1.SQLConfig = SQLConfig;
        var SQL = (function () {
            function SQL() {
            }
            SQL.prototype.query = function (options, callback) {
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
            };
            return SQL;
        }());
        data_1.SQL = SQL;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
var analyze;
(function (analyze) {
    var data;
    (function (data_2) {
        var ESConfig = (function () {
            function ESConfig() {
            }
            ESConfig.prototype.get = function () {
                return "<div class=\"form-group\">\n                                <label for=\"index\" class=\"col-sm-3 control-label\">\u7D22\u5F15</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control esindex\" name=\"index\"  required=\"required\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label for=\"index\" class=\"col-sm-3 control-label\">ES\u67E5\u8BE2\u8BED\u53E5</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control\" name=\"q\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u65F6\u95F4\u533A\u95F4</label>\n                                <div class=\"col-sm-9\">\n                                    <select class=\"form-control\" name=\"dateRange\">\n                                        <option value=\"today\">\u4ECA\u5929</option>\n                                        <option value=\"yesterday\">\u6628\u5929</option>\n                                        <option value=\"week\">\u672C\u5468</option>\n                                        <option value=\"month\">\u672C\u6708</option>\n                                        <option value=\"year\">\u4ECA\u5E74</option>\n                                    </select>\n                                </div>\n                            </div>\n                             <div class=\"form-group\">\n                                <label for=\"index\" class=\"col-sm-3 control-label\">\u65F6\u95F4\u5B57\u6BB5</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control\" name=\"dateField\" value=\"timestamp\" required=\"required\">\n                                </div>\n                            </div>";
            };
            return ESConfig;
        }());
        data_2.ESConfig = ESConfig;
        var ES = (function () {
            function ES() {
            }
            ES.prototype.search = function (options, agg, callback) {
                var _a = common.utils.getDateRange(options.dateRange), startDate = _a[0], endDate = _a[1];
                if (!(options.index && options.type && startDate && endDate)) {
                    return;
                }
                var q = options.q + this.getDateRangeCondition(startDate, endDate, options.dateField);
                var url = "/search/" + options.index + "/" + options.type + "?q=" + encodeURIComponent(q);
                if (agg) {
                    url += '&agg=' + encodeURIComponent(JSON.stringify(agg));
                }
                if (options.pageSize) {
                    url += '&pageSize=' + options.pageSize;
                }
                $.get(url).done(function (data) {
                    callback(data);
                });
            };
            ES.prototype.getDateRangeCondition = function (startDate, endDate, dateField) {
                return " +" + dateField + ":[\"" + startDate.utc().format("YYYY-MM-DD HH:mm:ss") + "\" TO \"" + endDate.utc().format("YYYY-MM-DD HH:mm:ss") + "\"}";
            };
            return ES;
        }());
        data_2.ES = ES;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
/// <reference path="es.ts" />
var analyze;
(function (analyze) {
    var data;
    (function (data_3) {
        var ESComponent = (function () {
            function ESComponent(options, callback) {
                this.options = options;
                this.callback = callback;
            }
            ESComponent.prototype.run = function () {
                var _this = this;
                this.options = $.extend({}, {
                    type: '_all',
                    q: '',
                    dateField: 'timestamp'
                }, this.options);
                var agg = this.generateAgg();
                new data_3.ES().search(this.options, agg, function (data) {
                    var value = _this.convert(data);
                    _this.callback(value);
                });
            };
            ESComponent.prototype.generateAgg = function () {
                return null;
            };
            ESComponent.prototype.convert = function (data) {
                return data;
            };
            return ESComponent;
        }());
        data_3.ESComponent = ESComponent;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
/// <reference path="escomponent.ts" />
var analyze;
(function (analyze) {
    var data;
    (function (data_4) {
        var ESQueryConfig = (function (_super) {
            __extends(ESQueryConfig, _super);
            function ESQueryConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            ESQueryConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    " <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u5217</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control esfields\" name=\"fields\" placeholder=\"\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u663E\u793A\u6761\u6570</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"number\" class=\"form-control\" name=\"pageSize\" placeholder=\"\">\n                                </div>\n                            </div>";
            };
            return ESQueryConfig;
        }(data_4.ESConfig));
        data_4.ESQueryConfig = ESQueryConfig;
        var ESQuery = (function (_super) {
            __extends(ESQuery, _super);
            function ESQuery(options, callback) {
                return _super.call(this, options, callback) || this;
            }
            ESQuery.prototype.convert = function (data) {
                var heads = this.options.fields.split(',').map(function (f) { return f.trim(); }).filter(function (f) { return f; });
                var bodys = [];
                var array = [];
                data.hits.hits.forEach(function (hits) {
                    var body = [];
                    heads.forEach(function (head) {
                        body.push(hits._source[head]);
                    });
                    bodys.push(body);
                });
                array["heads"] = heads;
                array["rows"] = bodys;
                return array;
            };
            return ESQuery;
        }(data_4.ESComponent));
        data_4.ESQuery = ESQuery;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
/// <reference path="escomponent.ts" />
var analyze;
(function (analyze) {
    var data;
    (function (data_5) {
        var ESMetricType;
        (function (ESMetricType) {
            ESMetricType[ESMetricType["count"] = 0] = "count";
            ESMetricType[ESMetricType["max"] = 1] = "max";
            ESMetricType[ESMetricType["min"] = 2] = "min";
            ESMetricType[ESMetricType["avg"] = 3] = "avg";
            ESMetricType[ESMetricType["sum"] = 4] = "sum";
            ESMetricType[ESMetricType["value_count"] = 5] = "value_count";
            ESMetricType[ESMetricType["cardinality"] = 6] = "cardinality";
        })(ESMetricType = data_5.ESMetricType || (data_5.ESMetricType = {}));
        var ESAggConfig = (function (_super) {
            __extends(ESAggConfig, _super);
            function ESAggConfig() {
                return _super !== null && _super.apply(this, arguments) || this;
            }
            ESAggConfig.prototype.get = function () {
                return _super.prototype.get.call(this) +
                    "\n                          <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u805A\u5408\u95F4\u9694</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"number\" class=\"form-control\" name=\"dateInterval\" placeholder=\"\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u95F4\u9694\u5355\u4F4D</label>\n                                <div class=\"col-sm-9\">\n                                <select class=\"form-control\" name=\"dateUnit\">\n                                <option value=\"d\">\u5929</option>\n                                <option value=\"h\">\u65F6</option>\n                                <option value=\"m\">\u5206</option>\n                                <option value=\"w\">\u5468</option>\n                                <option value=\"M\">\u6708</option>\n                                <option value=\"y\">\u5E74</option>\n                                </select>\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u65E5\u671F\u683C\u5F0F</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control\" name=\"dateFormat\" value=\"YYYY-MM-DD HH:mm:ss\" placeholder=\"\">\n                                </div>\n                            </div>\n\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u805A\u5408\u5B57\u6BB5</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control esfields\" name=\"termFields\" placeholder=\"\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u805A\u5408\u5927\u5C0F</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control esfields\" name=\"termSizes\" placeholder=\"\u5927\u5C0F\u4EE5\u9017\u53F7\u5206\u9694\u3002\u9ED8\u8BA4\u4E3A10\">\n                                </div>\n                            </div>\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u805A\u5408\u987A\u5E8F</label>\n                                <div class=\"col-sm-9\">\n                                <select class=\"form-control\" name=\"termOrder\">\n                                    <option value=\"desc\">\u964D\u5E8F</option>\n                                    <option value=\"asc\">\u5347\u5E8F</option>\n                                    </select>\n                                </div>\n                            </div>\n\n                            <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u6307\u6807</label>\n                                <div class=\"col-sm-9\">\n                                <select class=\"form-control\"  name=\"metricType\">\n                                    <option value=\"count\">\u65E5\u5FD7\u603B\u91CF</option>\n                                    <option value=\"max\">\u6307\u6807\u5B57\u6BB5\u6700\u5927\u503C</option>\n                                    <option value=\"min\">\u6307\u6807\u5B57\u6BB5\u6700\u5C0F\u503C</option>\n                                    <option value=\"avg\">\u6307\u6807\u5B57\u6BB5\u5E73\u5747\u503C</option>\n                                    <option value=\"sum\">\u6307\u6807\u5B57\u6BB5\u603B\u548C</option>\n                                    <option value=\"value_count\">\u6307\u6807\u5B57\u6BB5\u503C\u7684\u4E2A\u6570</option>\n                                    <option value=\"cardinality\">\u6307\u6807\u5B57\u6BB5\u4E0D\u540C\u503C\u7684\u4E2A\u6570</option>\n                                </select>\n                                </div>\n                            </div>\n                             <div class=\"form-group\">\n                                <label class=\"col-sm-3 control-label\">\u6307\u6807\u5B57\u6BB5</label>\n                                <div class=\"col-sm-9\">\n                                <input type=\"text\" class=\"form-control esfield\" name=\"metricField\" placeholder=\"\">\n                                </div>\n                            </div>\n                            ";
            };
            return ESAggConfig;
        }(data_5.ESConfig));
        data_5.ESAggConfig = ESAggConfig;
        var ESAgg = (function (_super) {
            __extends(ESAgg, _super);
            function ESAgg(options, callback) {
                var _this = _super.call(this, options, callback) || this;
                _this.termFiledArray = _this.options.termFields.split(',').map(function (t) { return t ? t.trim() : t; }).filter(function (t) { return t; });
                if (_this.options.termSizes) {
                    _this.termSizeArray = _this.options.termSizes.split(',').map(function (t) { return t ? t.trim() : t; }).map(function (t) { return Number(t); });
                }
                else {
                    _this.termSizeArray = [];
                }
                return _this;
            }
            ESAgg.prototype.generateAgg = function () {
                return this.generateDateHistogramAgg();
            };
            ESAgg.prototype.generateDateHistogramAgg = function () {
                var agg = this.generateTermsAgg();
                if (!this.options.dateInterval) {
                    return agg;
                }
                var datehistogram = {};
                var dateRange = common.utils.getDateRange(this.options.dateRange);
                datehistogram[this.options.dateField] =
                    {
                        "date_histogram": {
                            "field": this.options.dateField,
                            "interval": (this.options.dateInterval + this.options.dateUnit),
                            "min_doc_count": 0,
                            "offset": "-8h",
                            "extended_bounds": { "min": dateRange[0].valueOf(), "max": (dateRange[1].valueOf() - 1) }
                        }
                    };
                if (agg) {
                    datehistogram[this.options.dateField]['aggs'] = agg;
                }
                return datehistogram;
            };
            ESAgg.prototype.generateTermsAgg = function () {
                var agg = this.generateMetricAgg();
                if (this.termFiledArray == null) {
                    return agg;
                }
                for (var i = this.termFiledArray.length - 1; i >= 0; i--) {
                    var term = this.termFiledArray[i];
                    term = term.trim();
                    if (!term) {
                        continue;
                    }
                    var tmpAgg = {};
                    tmpAgg[term] = { "terms": { "field": term } };
                    var childAggs = agg;
                    if (childAggs) {
                        tmpAgg[term]["aggs"] = childAggs;
                    }
                    if (i == this.termFiledArray.length - 1) {
                        if (childAggs) {
                            tmpAgg[term]["terms"]["order"] = { "metric": this.options.termOrder };
                        }
                        else {
                            tmpAgg[term]["terms"]["order"] = { "_count": this.options.termOrder };
                        }
                    }
                    tmpAgg[term]["terms"]["size"] = this.termSizeArray[i] ? this.termSizeArray[i] : 10;
                    agg = tmpAgg;
                }
                return agg;
            };
            ESAgg.prototype.generateMetricAgg = function () {
                var agg = null;
                if (this.options.metricType != ESMetricType[ESMetricType.count]) {
                    agg = { "metric": {} };
                    agg.metric[this.options.metricType] = { "field": this.options.metricField };
                }
                return agg;
            };
            ESAgg.prototype.convert = function (data) {
                var aggregations = data.aggregations;
                if (!aggregations) {
                    return data.hits.total;
                }
                if (this.options.dateInterval) {
                    return this.getDataHistogram(aggregations);
                }
                else if (this.termFiledArray.length > 0) {
                    return this.getTerm(aggregations);
                }
                else {
                    return this.getMetric(aggregations);
                }
            };
            ESAgg.prototype.getDataHistogram = function (aggregations) {
                var _this = this;
                var dataHistogram = aggregations[this.options.dateField];
                var dataHistogramItems = [];
                dataHistogram.buckets.forEach(function (item) {
                    var dataHistogramItem = {};
                    dataHistogramItem['name'] = moment(item.key).format(_this.options.dateFormat);
                    if (_this.termFiledArray.length > 0) {
                        dataHistogramItem['value'] = _this.getTerm(item);
                    }
                    else {
                        dataHistogramItem['value'] = [{ name: '', value: _this.getMetric(item) }];
                    }
                    dataHistogramItems.push(dataHistogramItem);
                });
                return dataHistogramItems;
            };
            ESAgg.prototype.getTerm = function (termData, index) {
                var _this = this;
                if (index === void 0) { index = 0; }
                if (index < this.termFiledArray.length) {
                    var termFiled = this.termFiledArray[index];
                    var data_6 = termData[termFiled];
                    if (data_6) {
                        var items_1 = [];
                        data_6.buckets.forEach(function (bucket) {
                            var item = {};
                            var value;
                            if (index == _this.termFiledArray.length - 1) {
                                value = _this.getMetric(bucket);
                            }
                            else {
                                value = _this.getTerm(bucket, index + 1);
                            }
                            item = {
                                name: bucket.key,
                                value: value
                            };
                            items_1.push(item);
                        });
                        if (items_1.length > 0 && items_1[0].value instanceof Array) {
                            var flatItems = [];
                            for (var i in items_1) {
                                var name_1 = items_1[i].name;
                                for (var j in items_1[i].value) {
                                    flatItems.push({
                                        name: name_1 + '-' + items_1[i].value[j].name,
                                        value: items_1[i].value[j].value
                                    });
                                }
                            }
                            if (data_6.sum_other_doc_count > 0 && this.options.metricType == ESMetricType[ESMetricType.count]) {
                                flatItems.push({
                                    name: '其他',
                                    value: data_6.sum_other_doc_count
                                });
                            }
                            return flatItems;
                        }
                        else {
                            if (data_6.sum_other_doc_count > 0 && this.options.metricType == ESMetricType[ESMetricType.count]) {
                                items_1.push({
                                    name: '其他',
                                    value: data_6.sum_other_doc_count
                                });
                            }
                            return items_1;
                        }
                    }
                }
                return [];
            };
            ESAgg.prototype.getMetric = function (metricData) {
                var value;
                if (metricData.metric) {
                    value = metricData.metric.value;
                }
                else {
                    value = metricData.doc_count;
                }
                return value;
            };
            return ESAgg;
        }(data_5.ESComponent));
        data_5.ESAgg = ESAgg;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
/// <reference path="sql.ts" />
/// <reference path="esquery.ts" />
/// <reference path="esagg.ts" />
var analyze;
(function (analyze) {
    var data;
    (function (data) {
        var Type;
        (function (Type) {
            Type[Type["SQL"] = 0] = "SQL";
        })(Type = data.Type || (data.Type = {}));
        ;
        var Configs = (function () {
            function Configs() {
                this.configs = {};
                this.configs[Type.SQL] = new data.SQLConfig();
            }
            Configs.prototype.get = function (type) {
                return this.configs[type];
            };
            Configs.prototype.getAll = function () {
                return this.configs;
            };
            return Configs;
        }());
        data.Configs = Configs;
    })(data = analyze.data || (analyze.data = {}));
})(analyze || (analyze = {}));
/// <reference path="chart/chart.ts" />
/// <reference path="data/data.ts" />
var analyze;
(function (analyze) {
    var Analyzer = (function () {
        function Analyzer() {
            this.components = {};
            this.dataConfig = new analyze.data.Configs();
            this.chartConfig = new analyze.chart.Configs();
            this.register(analyze.data.Type.SQL, analyze.chart.Type.Metric, new SQLMetric());
            this.register(analyze.data.Type.SQL, analyze.chart.Type.Table, new SQLTable());
            this.register(analyze.data.Type.SQL, analyze.chart.Type.Bar, new SQLBar());
            this.register(analyze.data.Type.SQL, analyze.chart.Type.Pie, new SQLPie());
            this.register(analyze.data.Type.SQL, analyze.chart.Type.Map, new SQLMap());
        }
        Analyzer.prototype.get = function (dataType, chartType) {
            return this.components[dataType][chartType];
        };
        Analyzer.prototype.getDataTypes = function () {
            return Object.keys(this.components);
        };
        Analyzer.prototype.getChartTypes = function (dataType) {
            return Object.keys(this.components[dataType]);
        };
        Analyzer.prototype.getDataConfig = function (dataType) {
            return this.dataConfig.get(analyze.data.Type[dataType]).get();
        };
        Analyzer.prototype.getChartConfig = function (chartType) {
            return this.chartConfig.get(analyze.chart.Type[chartType]).get();
        };
        Analyzer.prototype.register = function (dataType, chartType, component) {
            var dataTypeName = analyze.data.Type[dataType];
            var chartTypeName = analyze.chart.Type[chartType];
            if (!this.components[dataTypeName]) {
                this.components[dataTypeName] = {};
            }
            this.components[dataTypeName][chartTypeName] = component;
        };
        return Analyzer;
    }());
    $(document).ready(function () {
        analyze.analyzer = new Analyzer();
    });
    var SQLMetric = (function () {
        function SQLMetric() {
        }
        SQLMetric.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.SQL().query(dataOptions, function (data) {
                new analyze.chart.Metric().paint(element, chartOptions, data["rows"][0][0]);
            });
        };
        return SQLMetric;
    }());
    var SQLTable = (function () {
        function SQLTable() {
        }
        SQLTable.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.SQL().query(dataOptions, function (data) {
                new analyze.chart.Table().paint(element, chartOptions, data["heads"], data["rows"]);
            });
        };
        return SQLTable;
    }());
    var SQLBar = (function () {
        function SQLBar() {
        }
        SQLBar.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.SQL().query(dataOptions, function (data) {
                var rows = data.rows;
                var nameValues = [];
                for (var i in rows) {
                    nameValues.push({ name: rows[i][1], value: rows[i][0] });
                }
                new analyze.chart.Bar().paint(element, chartOptions, nameValues.map(function (i) { return i.name; }), [''], [nameValues.map(function (i) { return i.value; })]);
            });
        };
        return SQLBar;
    }());
    var SQLPie = (function () {
        function SQLPie() {
        }
        SQLPie.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.SQL().query(dataOptions, function (data) {
                var rows = data.rows;
                var nameValues = [];
                for (var i in rows) {
                    nameValues.push({ name: rows[i][1], value: rows[i][0] });
                }
                new analyze.chart.Pie().paint(element, chartOptions, [''], [nameValues]);
            });
        };
        return SQLPie;
    }());
    var SQLMap = (function () {
        function SQLMap() {
        }
        SQLMap.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.SQL().query(dataOptions, function (data) {
                var rows = data.rows;
                var nameValues = [];
                for (var i in rows) {
                    nameValues.push({ name: rows[i][0], value: rows[i][1] });
                }
                new analyze.chart.Map().paint(element, chartOptions, nameValues);
            });
        };
        return SQLMap;
    }());
    var ESQueryTable = (function () {
        function ESQueryTable() {
        }
        ESQueryTable.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.ESQuery(dataOptions, function (data) {
                new analyze.chart.Table().paint(element, chartOptions, data["heads"], data["rows"]);
            }).run();
        };
        return ESQueryTable;
    }());
    var ESAggBar = (function () {
        function ESAggBar() {
        }
        ESAggBar.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.ESAgg(dataOptions, function (data) {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            var names = [];
                            var nameValues = [];
                            for (var i in data) {
                                for (var _i = 0, _a = data[i].value; _i < _a.length; _i++) {
                                    var termItem = _a[_i];
                                    if (names.indexOf(termItem.name) == -1) {
                                        names.push(termItem.name);
                                        nameValues.push([]);
                                    }
                                }
                            }
                            for (var i in data) {
                                for (var j in names) {
                                    for (var _b = 0, _c = data[i].value; _b < _c.length; _b++) {
                                        var item = _c[_b];
                                        if (names[j] == item.name) {
                                            nameValues[j][i] = item.value;
                                        }
                                    }
                                }
                            }
                            new analyze.chart.Bar().paint(element, chartOptions, data.map(function (i) { return i.name; }), names, nameValues);
                        }
                        else {
                            new analyze.chart.Bar().paint(element, chartOptions, data.map(function (i) { return i.name; }), [''], [data.map(function (i) { return i.value; })]);
                        }
                    }
                }
                else {
                    new analyze.chart.Bar().paint(element, chartOptions, [''], [''], [[data]]);
                }
            }).run();
        };
        return ESAggBar;
    }());
    var ESAggPie = (function () {
        function ESAggPie() {
        }
        ESAggPie.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.ESAgg(dataOptions, function (data) {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            new analyze.chart.Pie().paint(element, chartOptions, data.map(function (i) { return i.name; }), data.map(function (i) { return i.value; }));
                        }
                        else {
                            new analyze.chart.Pie().paint(element, chartOptions, [''], [data]);
                        }
                    }
                }
                else {
                    new analyze.chart.Pie().paint(element, chartOptions, [''], [[{ name: '', value: data }]]);
                }
            }).run();
        };
        return ESAggPie;
    }());
    var ESAggMetic = (function () {
        function ESAggMetic() {
        }
        ESAggMetic.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.ESAgg(dataOptions, function (data) {
                if (data instanceof Array) {
                    new analyze.chart.Metric().paint(element, chartOptions, '不支持');
                }
                else {
                    new analyze.chart.Metric().paint(element, chartOptions, data);
                }
            }).run();
        };
        return ESAggMetic;
    }());
    var ESAggTable = (function () {
        function ESAggTable() {
        }
        ESAggTable.prototype.run = function (element, dataOptions, chartOptions) {
            new analyze.data.ESAgg(dataOptions, function (data) {
                if (data instanceof Array) {
                    if (data.length > 0) {
                        if (data[0].value instanceof Array) {
                            var names = [];
                            var dateValues_1 = [];
                            for (var i in data) {
                                for (var _i = 0, _a = data[i].value; _i < _a.length; _i++) {
                                    var termItem = _a[_i];
                                    if (names.indexOf(termItem.name) == -1) {
                                        names.push(termItem.name);
                                    }
                                }
                                dateValues_1.push([]);
                            }
                            for (var i in data) {
                                for (var j in names) {
                                    dateValues_1[i][j] = null;
                                    for (var _b = 0, _c = data[i].value; _b < _c.length; _b++) {
                                        var item = _c[_b];
                                        if (names[j] == item.name) {
                                            dateValues_1[i][j] = item.value;
                                        }
                                    }
                                }
                            }
                            new analyze.chart.Table().paint(element, chartOptions, [''].concat(names), data.map(function (i, index) { return [i.name].concat(dateValues_1[index]); }));
                        }
                        else {
                            new analyze.chart.Table().paint(element, chartOptions, data.map(function (i) { return i.name; }), [data.map(function (i) { return i.value; })]);
                        }
                    }
                }
                else {
                    new analyze.chart.Table().paint(element, chartOptions, [], [[data]]);
                }
            }).run();
        };
        return ESAggTable;
    }());
})(analyze || (analyze = {}));
var common;
(function (common) {
    var utils;
    (function (utils) {
        utils.maxPageSize = 2147483647;
        function getParameterByName(name, url) {
            if (!url)
                url = window.location.href;
            name = name.replace(/[\[\]]/g, "\\$&");
            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex.exec(url);
            if (!results)
                return null;
            if (!results[2])
                return '';
            return decodeURIComponent(results[2].replace(/\+/g, " "));
        }
        utils.getParameterByName = getParameterByName;
        function getDateRange(dateRange) {
            var startDate, endDate;
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
        utils.getDateRange = getDateRange;
        function decimalFormat(value) {
            if (value == undefined || value == null) {
                return 0;
            }
            var strValue = value.toString();
            if (strValue.indexOf('.') != -1) {
                if ((value > 0 && value < 0.01) || (value < 0 && value > -0.01)) {
                    return "0.00";
                }
                return parseFloat(strValue).toFixed(2);
            }
            else {
                return value;
            }
        }
        utils.decimalFormat = decimalFormat;
        function convertCode(codeType, codes, callback) {
            if (codeType) {
                $.get('/code/get?type=' + codeType + '&codes=' + codes).done(callback);
            }
            else {
                callback({});
            }
        }
        utils.convertCode = convertCode;
    })(utils = common.utils || (common.utils = {}));
})(common || (common = {}));
var page;
(function (page) {
    var alarms;
    (function (alarms) {
        function init() {
            load();
            setInterval(load, 1 * 60 * 1000);
        }
        alarms.init = init;
        function getErrorKey(r) {
            return r.c2 + '-' + r.c3 + '-' + r.c4;
        }
        function compare(errorRangeMetric, lastErrorRangeMetric) {
            if (lastErrorRangeMetric) {
                if ((parseFloat(errorRangeMetric.c6) - parseFloat(lastErrorRangeMetric.c6) > 10
                    || parseInt(errorRangeMetric.c5) / parseInt(lastErrorRangeMetric.c5) > 1.5)
                    && (parseInt(errorRangeMetric.c5) - parseInt(lastErrorRangeMetric.c5)) > 100) {
                    return true;
                }
            }
            else {
                if (parseFloat(errorRangeMetric.c6) > 5 && parseInt(errorRangeMetric.c5) > 100) {
                    return true;
                }
            }
            return false;
        }
        function load() {
            var errors = $('#errors');
            errors.empty();
            $.get("/rangemetrics/last?c=" + INDEX + "%2Cerror").done(function (rangeMetrics) {
                if (rangeMetrics.length == 0) {
                    return;
                }
                var actions = rangeMetrics.map(function (r) { return r.c2; });
                var funcs = rangeMetrics.map(function (r) { return r.c3; });
                var metricTime = rangeMetrics[0].metricTime;
                $.get("/utils/lastsametypeday?date=" + metricTime + "&size=3")
                    .done(function (dates) {
                    var oldDates = [metricTime - 5 * 60 * 1000].concat(dates);
                    $.get("/rangemetrics?metricTimes=" + oldDates + "&c=" + INDEX + "%2Cerror")
                        .done(function (oldRangeMetrics) {
                        Object.keys(oldRangeMetrics).forEach(function (t) {
                            var rs = oldRangeMetrics[t];
                            var ro = {};
                            rs.forEach(function (r) {
                                ro[getErrorKey(r)] = r;
                            });
                            oldRangeMetrics[t] = ro;
                        });
                        common.utils.convertCode('1', actions, function (actionMap) {
                            common.utils.convertCode('2', funcs, function (funcMap) {
                                var table = "<table class=\"table table-bordered\">\n                                                <thead>\n                                                <tr>\n                                                    <td colspan=\"3\"></td> <td colspan=\"2\">" + moment(metricTime).format('MM-DD HH:mm') + "</td>" + oldDates.map(function (d) { return "<td colspan=\"2\">" + moment(d).format('MM-DD HH:mm'); }).join('') + "\n                                                </tr>\n                                                <tr>\n                                                    <td>\u8BF7\u6C42\u53F7</td> <td>\u529F\u80FD\u53F7</td> <td>\u9519\u8BEF\u53F7</td><td>\u9519\u8BEF\u6570</td> <td>\u9519\u8BEF\u6BD4\u4F8B</td>" + oldDates.map(function (d) { return '<td>错误数</td> <td>错误比例</td>'; }).join('') + "\n                                                </tr>\n                                                </thead>\n                                                <tbody>\n                                                    " + rangeMetrics.map(function (r) {
                                    var key = getErrorKey(r);
                                    var isDanger = compare(r, oldRangeMetrics[oldDates[0]][key]) && compare(r, oldRangeMetrics[oldDates[1]][key]);
                                    var row = "<tr class=\"" + (isDanger ? 'danger' : '') + "\"><td>" + r.c2 + actionMap[r.c2] + "</td><td>" + r.c3 + funcMap[r.c3] + "</td><td>" + r.c4 + "</td><td>" + r.c5 + "</td><td>" + r.c6 + "%</td>";
                                    for (var _i = 0, oldDates_1 = oldDates; _i < oldDates_1.length; _i++) {
                                        var t = oldDates_1[_i];
                                        var oldRangeMetric = oldRangeMetrics[t][key];
                                        if (oldRangeMetric) {
                                            row += "<td>" + oldRangeMetric.c5 + "</td><td>" + oldRangeMetric.c6 + "%</td>";
                                        }
                                        else {
                                            row += "<td></td><td></td>";
                                        }
                                    }
                                    return row;
                                }).join('') + "\n                                                </tbody>\n                                            </table>";
                                errors.append(table);
                            });
                        });
                    });
                });
            });
        }
    })(alarms = page.alarms || (page.alarms = {}));
})(page || (page = {}));
var page;
(function (page) {
    var dashboard;
    (function (dashboard) {
        var component;
        (function (component) {
            var config = {};
            function saveConfig() {
                var dataConfig = $('#dataConfigForm').serializeObject();
                var chartConfig = $('#chartConfigForm').serializeObject();
                config = { data: dataConfig, chart: chartConfig };
            }
            ;
            function initDataConfigVal() {
                for (var name_2 in config.data) {
                    if (name_2 != 'dataType') {
                        $("#dataConfigForm [name=\"" + name_2 + "\"]").val(config.data[name_2]);
                    }
                }
            }
            function initChartConfigVal() {
                for (var name_3 in config.chart) {
                    if (name_3 != 'chartType') {
                        $("#chartConfigForm [name=\"" + name_3 + "\"]").val(config.chart[name_3]);
                    }
                }
            }
            function init() {
                var analyzer = analyze.analyzer;
                var dataType = $('#dataType');
                var chartType = $('#chartType');
                var configStr = common.utils.getParameterByName('config', null);
                if (configStr) {
                    config = JSON.parse(configStr);
                }
                dataType.html(analyzer.getDataTypes().map(function (type) { return "<option vlaue=\"" + type + "\">" + type + "</option>"; }).join(''));
                if (config.data) {
                    dataType.val(config.data.dataType);
                }
                $('#dataConfigs').html(analyzer.getDataConfig(dataType.val()));
                if (config.data) {
                    initDataConfigVal();
                }
                chartType.html(analyzer.getChartTypes(dataType.val()).map(function (type) { return "<option vlaue=\"" + type + "\">" + type + "</option>"; }).join(''));
                if (config.chart) {
                    chartType.val(config.chart.chartType);
                }
                $('#chartConfigs').html(analyzer.getChartConfig(chartType.val()));
                if (config.chart) {
                    initChartConfigVal();
                }
                dataType.on("change", function (event) {
                    saveConfig();
                    $('#dataConfigs').html(analyzer.getDataConfig(dataType.val()));
                    initDataConfigVal();
                    chartType.html(analyzer.getChartTypes(dataType.val()).map(function (type) { return "<option vlaue=\"" + type + "\">" + type + "</option>"; }).join(''));
                    if (analyzer.getChartTypes(dataType.val()).indexOf(config.chart.chartType) == -1) {
                        chartType.change();
                    }
                    else {
                        chartType.val(config.chart.chartType);
                    }
                });
                chartType.on("change", function (event) {
                    saveConfig();
                    $('#chartConfigs').html(analyzer.getChartConfig(chartType.val()));
                    initChartConfigVal();
                });
                $('#preview').on("click", function (event) {
                    saveConfig();
                    analyzer.get(config.data.dataType, config.chart.chartType).run(document.getElementById("chart"), config.data, config.chart);
                });
                $('#save').on("click", function (event) {
                    saveConfig();
                    var selected = parent['$'](".selected");
                    selected.attr("data-config", JSON.stringify(config));
                    var index = parent['layer'].getFrameIndex(window.name);
                    parent['layer'].close(index);
                });
            }
            component.init = init;
        })(component = dashboard.component || (dashboard.component = {}));
    })(dashboard = page.dashboard || (page.dashboard = {}));
})(page || (page = {}));
var page;
(function (page) {
    var dashboard;
    (function (dashboard_1) {
        var dashboard;
        (function (dashboard) {
            function init() {
                var id = common.utils.getParameterByName('id', null);
                if (id) {
                    page.dashboard.layout.loadLayout(id);
                }
                else {
                    var layouts_1 = $('#layouts');
                    layouts_1.show();
                    page.dashboard.layout.loadLayouts(true);
                    layouts_1.on('change', function () {
                        page.dashboard.layout.loadLayout(layouts_1.val());
                    });
                }
            }
            dashboard.init = init;
        })(dashboard = dashboard_1.dashboard || (dashboard_1.dashboard = {}));
    })(dashboard = page.dashboard || (page.dashboard = {}));
})(page || (page = {}));
var page;
(function (page_1) {
    var dashboard;
    (function (dashboard) {
        var layout;
        (function (layout_1) {
            function getColSize() {
                var val = $('#colSize').val();
                if (val.indexOf('.') >= 0) {
                    return NaN;
                }
                var colSize = Number($('#colSize').val().trim());
                return colSize;
            }
            function initElement(elements) {
                var analyzer = analyze.analyzer;
                elements.each(function (index, elem) {
                    var config = JSON.parse(elem.getAttribute('data-config'));
                    if (config && config.data && config.chart) {
                        analyzer.get(config.data.dataType, config.chart.chartType).run(elem, config.data, config.chart);
                    }
                });
            }
            layout_1.initElement = initElement;
            function loadLayout(layout) {
                $("#columns").empty();
                $.get("/customization/" + layout + "/customization").done(function (data) {
                    if (!data.id) {
                        return;
                    }
                    
                    var columns = JSON.parse(data.config);
                    columns.forEach(function (column) {
                        var col = $("<div class=\"col-sm-" + column.width + " column\" data-col=\"" + column.width + "\"></div>");
                        col.attr("data-config", JSON.stringify(column.config));
                        $("#columns").append(col);
                    });
                    initElement($('#columns .column'));
                });
            }
            layout_1.loadLayout = loadLayout;
            function loadLayouts(isAll, selectValue) {
                var layouts = $("#layouts");
                $.ajax({
                    url: "/customization/" + isAll + "/types",
                    success: function (data) {
                        layouts.empty();
                        if (Object.keys(data).length === 0) {
                            var row = '<option value="首页">首页</option>';
                            layouts.append(row);
                            return;
                        }
                        var homePage = [];
                        
                        for (var key in data) {
                            var page_2 = data[key];
                            if (page_2 == '首页') {
                                homePage[page_2] = key;
                                break;
                            }
                        }
                        {
                            var row = void 0;
                            for (var key in data) {
                                var page_3 = data[key];
                                if (page_3 != '首页') {
                                    var row_1 = "<option value=" + key + ">" + page_3 + "</option>";
                                    layouts.append(row_1);
                                }
                            }
                            console.log(homePage['首页'])
                            if (homePage['首页']) {
                                row = "<option value=" + homePage['首页'] + ">" + '首页' + "</option>";
                            }
                            else {
                                //row = '<option value="首页">首页</option>';
                            }
                            layouts.prepend(row);
                            
                        }
                        if (selectValue) {
                            $("#layouts option:contains(\"" + selectValue + "\")").map(function () {
                                if ($(this).text() == selectValue) {
                                    return this;
                                }
                            }).prop("selected", "selected");
                        }
                        layouts.change();
                    },
                    error: function (data) {
                        layer.alert("加载自定义仪表盘失败。请联系系统管理员处理。", { icon: 2 });
                    }
                });
            }
            layout_1.loadLayouts = loadLayouts;
            function saveLayout() {
                var columns = [];
                var selectValue = $('#layouts').find("option:selected").text();
                $('#columns .column').each(function (index, elem) {
                    var width = parseInt(elem.getAttribute('data-col'));
                    var configStr = elem.getAttribute('data-config');
                    var config = configStr && configStr.length > 0 ? JSON.parse(configStr) : {};
                    columns.push({
                        width: width,
                        config: config
                    });
                });
                $.ajax({
                    type: "POST",
                    url: "/manage/customization/" + $('#layouts').val() + "/" + selectValue + "/customization/add",
                    contentType: "application/json",
                    data: JSON.stringify({ config: JSON.stringify(columns) }),
                    success: function (data) {
                        loadLayouts(false, selectValue);
                        layer.alert("保存成功!", { icon: 1, time: 1500 });
                    },
                    error: function (e, xhr, opt) {
                        layer.alert("保存失败! " + e.responseJSON.message, { icon: 2 });
                    }
                });
            }
            function init() {
                $('#columns').sortable({
                    revert: true
                });
                $('#draggable').draggable({
                    connectToSortable: '#columns',
                    helper: function () {
                        var colSize = getColSize();
                        if (!isNaN(colSize)) {
                            return $("<div class=\"col-sm-" + colSize + " column\" data-col=\"" + colSize + "\"></div>");
                        }
                        else {
                            return false;
                        }
                    },
                    revert: 'invalid',
                });
                $('#draggable').draggable('disable');
                $('#colSize').on('change', function () {
                    var colSize = getColSize();
                    if (!isNaN(colSize) && colSize <= 12 && colSize >= 1) {
                        $('#draggable').text('拖动');
                        $('#draggable').draggable('enable');
                    }
                    else {
                        $('#draggable').text('列宽应该是1到12的整数');
                        $('#draggable').draggable('disable');
                    }
                });
                $('#draggable').on('dragstop', function (event, ui) {
                    $(ui.helper).css('width', '');
                    $(ui.helper).css('height', '');
                });
                $('#columns').on('click', '.column', function () {
                    if ($(this).hasClass('selected')) {
                        $('.selected').removeClass('selected');
                    }
                    else {
                        $('.selected').removeClass('selected');
                        $(this).addClass('selected');
                    }
                });
                $('#removeColumn').on('click', function () {
                    $('.selected').remove();
                });
                $('#modifyColumn').on('click', function () {
                    if ($('.selected').length != 1) {
                        return;
                    }
                    layer.open({
                        type: 2,
                        title: '组件编辑',
                        area: ['100%', '100%'],
                        content: '/page/dashboard/component.html?config=' + encodeURIComponent($.trim($('.selected').attr('data-config'))),
                        end: function (index, layero) {
                            initElement($('.selected'));
                        }
                    });
                });
                $('#copyColumn').on('click', function () {
                    var selected = $('.selected');
                    if (selected.length != 1) {
                        return;
                    }
                    var colSize = selected.attr('data-col');
                    var config = selected.attr('data-config');
                    var newCol = $("<div class=\"col-sm-" + colSize + " column\" data-col=\"" + colSize + "\"></div>");
                    newCol.attr('data-config', config);
                    selected.after(newCol);
                    initElement(newCol);
                });
                $('#zoomIn').on('click', function () {
                    $('.selected').each(function (index, elem) {
                        var colSize = parseInt(elem.getAttribute('data-col').trim());
                        if (!isNaN(colSize) && colSize < 12) {
                            elem.setAttribute('data-col', "" + (colSize + 1));
                            elem.className = elem.className.replace("col-sm-" + colSize, "col-sm-" + (colSize + 1));
                        }
                    });
                    initElement($('.selected'));
                });
                $('#zoomOut').on('click', function () {
                    $('.selected').each(function (index, elem) {
                        var colSize = parseInt(elem.getAttribute('data-col').trim());
                        if (!isNaN(colSize) && colSize > 1) {
                            elem.setAttribute('data-col', "" + (colSize - 1));
                            elem.className = elem.className.replace("col-sm-" + colSize, "col-sm-" + (colSize - 1));
                        }
                    });
                    initElement($('.selected'));
                });
                $('#newLayout').on('click', function () {
                    layer.prompt({
                        formType: 0,
                        title: "新增自定义仪表盘"
                    }, function (value, index, elem) {
                        layer.close(index);
                        var select = $('#layouts');
                        if ($("#layouts option[text=\"" + value + "\"]").length == 0) {
                            select.append("<option value='-1'>" + value + "</option>");
                        }
                        else {
                            layer.alert("\u540D\u4E3A" + value + "\u7684\u4EEA\u8868\u76D8\u5DF2\u7ECF\u5B58\u5728.", { icon: 2, time: 1500 });
                        }
                        select.val('-1');
                        select.change();
                    });
                });
                $('#copyLayout').on('click', function () {
                    layer.prompt({
                        formType: 0,
                        title: "复制自定义仪表盘"
                    }, function (value, index, elem) {
                        layer.close(index);
                        var select = $('#layouts');
                        select.append("<option value=" + value + ">" + value + "</option>");
                        select.val(value);
                        saveLayout();
                    });
                });
                var loadSelectUserGroups = function () {
                    $.get("/customization/" + $("#layouts").val() + "/assigned").done(function (groups) {
                        var userGroups = [];
                        groups.forEach(function (element) {
                            userGroups.push(element.groupId);
                        });
                        $.ajax({ url: "/usergroups?pageSize=" + common.utils.maxPageSize, success: function (data) {
                                var select = $("#selectUserGroups");
                                select.empty();
                                for (var i = 0; i < data.length; i++) {
                                    var rowData = data[i];
                                    if ($.inArray(rowData.id, userGroups) == -1) {
                                        var row = '<option value="' + rowData.id + '">' + rowData.groupName + '</option>';
                                        select.append(row);
                                    }
                                }
                            } });
                    });
                };
                $('#shareLayout').on('click', function () {
                    var type = $('#layouts').find("option:selected").text();
                    if (type == '首页') {
                        layer.alert("\u8BF7\u5171\u4EAB\u9996\u9875\u4EE5\u5916\u7684\u4EEA\u8868\u76D8.", { icon: 2, time: 1500 });
                        return;
                    }
                    loadSelectUserGroups();
                    $("#sharename").text(type);
                    $('#userGroupsModal').modal('show');
                });
                $("#saveUserGroupsButton").on("click", function () {
                    var selectUserGroups = $("#selectUserGroups").val();
                    if (!selectUserGroups) {
                        layer.alert("请选择用户组后保存! ", { icon: 2 });
                        return;
                    }
                    $.ajax({
                        type: "POST",
                        url: "/manage/customization/" + $("#layouts").val() + "/customization/share",
                        contentType: "application/json",
                        data: JSON.stringify(selectUserGroups),
                        success: function (data) {
                            layer.alert("共享成功!", { icon: 1, time: 1500 });
                            $('#userGroupsModal').modal('hide');
                        },
                        error: function (e, xhr, opt) {
                            layer.alert("共享失败! " + e.responseJSON.message, { icon: 2 });
                        }
                    });
                });
                $('#layouts').on('change', function () {
                    loadLayout($(this).val());
                });
                $('#saveLayout').on('click', function () {
                    var type = $('#layouts').find("option:selected").text();
                    layer.confirm("仪表盘类型为'" + type + "'", { icon: 3, title: "保存仪表盘" }, function (index) {
                        saveLayout();
                    });
                });
                $('#deleteLayout').on('click', function () {
                    var layout = $("#layouts").val();
                    var type = $('#layouts').find("option:selected").text();
                    layer.confirm("仪表盘类型为'" + type + "'", { icon: 3, title: "删除仪表盘" }, function (index) {
                        $.get("/manage/customization/" + $("#layouts").val() + "/customization/remove").done(function () {
                            layer.alert("删除自定义仪表盘成功", { icon: 1, time: 1500 });
                            loadLayouts(false);
                        });
                    });
                });
                $("#shareManageLayout").on("click", function () {
                    layer.open({
                        type: 2,
                        title: '共享管理',
                        area: ['100%', '100%'],
                        content: 'sharemanage.html',
                        scrollbar: false
                    });
                });
                loadLayouts(false);
            }
            layout_1.init = init;
        })(layout = dashboard.layout || (dashboard.layout = {}));
    })(dashboard = page_1.dashboard || (page_1.dashboard = {}));
})(page || (page = {}));
var page;
(function (page) {
    var dashboard;
    (function (dashboard) {
        var sharemanage;
        (function (sharemanage) {
            function init() {
                $("#customizations").on("click", ".deleteButton", function () {
                    var row = $(this).parent().parent();
                    var customizationIdTD = row.children().first();
                    var customizationId = customizationIdTD.text();
                    var userNameTd = customizationIdTD.next();
                    var typeTd = userNameTd.next();
                    var type = typeTd.text();
                    layer.confirm("仪表盘类型为‘" + type + "'", { icon: 3, title: "删除共享仪表盘" }, function (index) {
                        $.ajax({
                            type: "GET",
                            url: "/manage/customization/" + customizationId + "/share/remove",
                            success: function (data) {
                                layer.alert("删除成功!", { icon: 1, time: 1500 });
                                loadShare();
                            },
                            error: function (e, xhr, opt) {
                                layer.alert("删除失败! " + e.responseJSON.message, { icon: 2 });
                            }
                        });
                        layer.close(index);
                    });
                });
                loadShare();
            }
            sharemanage.init = init;
            function loadShare() {
                $.get('/customization/share').done(function (data) {
                    var table = $("#customizations");
                    table.empty();
                    for (var i = 0; i < data.length; i++) {
                        var rowData = data[i];
                        var row = "<tr><td>" + rowData.customizationId + "</td><td>" + rowData.username + "</td><td>" + rowData.type + "</td>"
                            + '<td><button type="button" class="btn btn-danger btn-xs deleteButton">删除</button></td>'
                            + '</tr>';
                        table.append(row);
                    }
                });
            }
        })(sharemanage = dashboard.sharemanage || (dashboard.sharemanage = {}));
    })(dashboard = page.dashboard || (page.dashboard = {}));
})(page || (page = {}));
