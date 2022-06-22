/// <reference path="common.ts" />

namespace analyze {
    export namespace chart {
        declare var echarts;

        interface ESOptions extends ChartOptions {
            readonly height: string;
            readonly legendShow: string;
            readonly legendOrient: string;
            readonly legendLeft: string;
            readonly legendTop: string;
        }

        class ESConfig extends ChartConfig {
            get() {
                return super.get() +
                    `<div class="form-group">
                        <label class="col-sm-3 control-label">图像高度</label>
                        <div class="col-sm-9">
                        <input type="text" class="form-control" name="height" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">标志图形</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="legendShow">
                                <option value="true">显示默认</option>
                                <option value="false">不显示</option>
                            </select>
                        </div>
                            <div class="col-sm-4">
                            <select class="form-control" name="legendOrient">
                                <option value="horizontal">水平朝向</option>
                                <option value="vertical">垂直朝向</option>
                            </select>
                        </div>
                        <div class="col-sm-offset-3 col-sm-4">
                            <select class="form-control" name="legendLeft">
                                <option value="auto">水平默认</option>
                                <option value="left">水平左</option>
                                <option value="center">水平中</option>
                                <option value="right">水平下</option>
                            </select>
                        </div>
                            <div class="col-sm-4">
                            <select class="form-control" name="legendTop">
                                <option value="auto">垂直默认</option>
                                <option value="top">垂直上</option>
                                <option value="middle">垂直中</option>
                                <option value="bottom">垂直下</option>
                            </select>
                        </div>
                    </div>`;
    }
        }

        export class Echart {
            paint(element: HTMLDivElement, chartOptions: ESOptions, options) {
                let chart = `<div class="ibox">
                                    <div class="ibox-title">
                                        <h5>${chartOptions.title}</h5>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="echart" style="height: 100%"></div>
                                    </div>
                                 </div>`;
                element.innerHTML = chart;

                let $content = $(element.getElementsByClassName('ibox-content'));

                if (chartOptions.height) {
                    $content.height(chartOptions.height);
                } else {
                    let width = $content.width();
                    if (width > 400) {
                        $content.height(400);
                    } else {
                        $content.height(width);
                    }
                }

                var myChart = echarts.init(element.querySelector(".echart"));
               
                let customOptions = {legend: <any>{}};
                customOptions.legend.show = chartOptions.legendShow == 'true';
                customOptions.legend.orient = chartOptions.legendOrient;
                customOptions.legend.left = chartOptions.legendLeft;
                customOptions.legend.top = chartOptions.legendTop;

                myChart.setOption(options, true, true);
                myChart.setOption(customOptions);

                if(chartOptions['polling'] == 'true'){
                    var index = 1;
                    setInterval(function(){
                        var op = myChart.getOption();
                        var data = op.series[0].data;

                        myChart.dispatchAction({
                            type: 'showTip',
                            seriesIndex:0 ,
                            dataIndex: index
                        });

                        index++

                        if(data.length < index){
                            myChart.setOption(op);
                            index = 0;
                        }
                        
                    }, 3000);
                }
                

                $(window).resize(function () {
                    myChart.resize();
                });
            }
        }

        export interface PieOptions extends ESOptions {
            readonly codeType: string;
        }

        export class PieConfig extends ESConfig {
            get() {
                return super.get() +
                    `<div class="form-group">
                        <label class="col-sm-3 control-label">编码类型</label>
                        <div class="col-sm-9">
                        <input type="text" class="form-control" name="codeType" placeholder="">
                        </div>
                    </div>`;
            }
        }

        export class Pie {
            paint(element: HTMLDivElement, chartOptions: PieOptions, keys: string[], datas: { name: string, value: string }[][]) {
                let names = {};
                datas.forEach(d => {
                    d.forEach(i => {
                        names[i.name] = true;
                    });
                });

                common.utils.convertCode(chartOptions.codeType, Object.keys(names), (nameMap) => {
                    datas.forEach(d => {
                        d.forEach(i => {
                            let convertName = nameMap[i.name];
                            if (convertName) {
                                i.name = convertName;
                            }
                        });
                    });

                    let seriesData = [];
                    for (let i = 0; i < datas.length; i++) {
                        seriesData[i] = {
                            type: 'pie',
                            name: keys[i],
                            data: datas[i]
                        };
                    }

                    if (seriesData.length > 1) {
                        for (let i = 0; i < datas.length; i++) {
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
            }
        }

        export interface BarOptions extends ESOptions {
            readonly stack: string;
        }

        export class BarConfig extends ESConfig {
            get() {
                return super.get() +
                    `<div class="form-group">
                        <label for="stack" class="col-sm-3 control-label">堆栈显示</label>
                        <div class="col-sm-9">
                        <select class="form-control" name="stack">
                        <option value="true">是</option>
                        <option value="">否</option>
                        </select>
                        </div>
                    </div>`;
            }
        }

        export class Bar {
            paint(element: HTMLDivElement, barOptions: BarOptions, xValues: String[], legends: String[], datas: string[][]) {
                var echart = new chart.Echart();

                let seriesData = [];
                for (let i = 0; i < datas.length; i++) {
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
                    yAxis: {
                    },
                    series: seriesData
                });
            }
        }

        export interface MapOptions extends ESOptions {
            readonly area: string;
            readonly polling: true;
            readonly high: number;
            readonly low: number;
        }

        export class MapConfig extends ESConfig {
            get() {
                return super.get() +
                    `<div class="form-group">
                        <label for="area" class="col-sm-3 control-label">区域</label>
                        <div class="col-sm-9">
                        <select class="form-control" name="area">
                        <option value="china">全国</option>
                        <option value="xiamen">本市</option>
                        <option value="fujian">福建</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="polling" class="col-sm-3 control-label">是否轮询</label>
                        <div class="col-sm-9">
                        <select class="form-control" name="polling">
                        <option value="true">是</option>
                        <option value="false">否</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="low" class="col-sm-3 control-label">统计范围</label>
                        <div class="col-sm-4">
                        <input class="form-control" readOnly="true" name="low" type="number" min="0" value="0">
                        </div>
                        <label for="high" class="col-sm-1 control-label">至</label>
                        <div class="col-sm-4">
                        <input class="form-control" name="high" type="number" min="0">
                        </div>
                    </div>`;
            }
        }

        export class Map {
            paint(element: HTMLDivElement, mapOptions: MapOptions, datas: string[]) {
                var echart = new chart.Echart();
                
                $.get('/json/map/' + mapOptions.area + '.json', function (json) {
                    echarts.registerMap(mapOptions.area, json);
                    let seriesData = [];
                   
                    seriesData[0] = {
                        name: mapOptions.title,
                        type: 'map',
                        mapType: mapOptions.area,
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{
                                label: {show:true},
                                areaColor: '#3be2fb',
                                color: '#000000',
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        data: datas
                    }

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
                            text:['高','低'],
                            realtime: false,
                            calculable: true,
                            inRange: {
                                color: ['lightskyblue','yellow', 'orangered']
                            }
                        },
                        series: seriesData
                    });
                })
            }
        }
    }
}