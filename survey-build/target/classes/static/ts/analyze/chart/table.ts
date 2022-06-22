/// <reference path="common.ts" />

namespace analyze {
    export namespace chart {
        export class Table {
            paint(element: HTMLDivElement, options: ChartOptions, head: string[], body: string[][]) {
                let chart = `<div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>${options.title}</h5>
                                </div>
                                <div class="ibox-content">
                                    <table class="table table-bordered ">
                                        <thead>
                                        <tr>
                                            ${head.map(h => `<th>${h?h:''}</th>`).join('')}
                                        </tr>
                                        </thead>
                                        <tbody>
                                            ${body.map(r => `<tr>${r.map(d => `<td>${d?d:''}</td>`).join('')}</tr>`).join('')}
                                        </tbody>
                                    </table>
                                </div>
                            </div>`;
                element.innerHTML = chart;
            }
        }
    }
}