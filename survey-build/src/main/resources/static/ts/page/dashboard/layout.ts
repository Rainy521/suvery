namespace page {
    export namespace dashboard {
        export namespace layout {
            declare var layer;

            function getColSize(): number {
                let val: string = $('#colSize').val();
                if (val.indexOf('.') >= 0) {
                    return NaN;
                }

                let colSize = Number($('#colSize').val().trim());
                return colSize;
            }

            export function initElement(elements: JQuery) {
                let analyzer = analyze.analyzer;
                elements.each((index: number, elem: Element) => {
                    let config = JSON.parse(elem.getAttribute('data-config'));

                    if (config && config.data && config.chart) {
                        analyzer.get(config.data.dataType, config.chart.chartType).run(elem, config.data, config.chart);
                    }
                });
            }

            export function loadLayout(layout: string) {
                $("#columns").empty();
                $.get(`/customization/${layout}/customization`).done(function (data) {
                    if (!data.id) {
                        return;
                    }

                    let columns = <Array<any>>JSON.parse(data.config);
                    columns.forEach((column) => {
                        let col = $(`<div class="col-sm-${column.width} column" data-col="${column.width}"></div>`);
                        col.attr("data-config", JSON.stringify(column.config));
                        $("#columns").append(col);
                    });

                    initElement($('#columns .column'));
                });
            }

            export function loadLayouts(isAll: boolean, selectValue?: string) {
                let layouts = $("#layouts");

                $.ajax({
                    url: `/customization/${isAll}/types`,
                    success: function (data) {
                        layouts.empty();
                        if (Object.keys(data).length === 0) {
                            let row = '<option value="??????">??????</option>';
                            layouts.append(row);
                            return;
                        }

                        let homePage = [];

                        for (let key in data) {
                            let page = data[key];
                            if (page == '??????') {
                                homePage[page] = key;
                                break;
                            }
                        }

                        {
                            let row;

                            if(homePage['??????']){
                                row = `<option value=${homePage['??????']}>${'??????'}</option>`;
                            }else{
                                row = '<option value="??????">??????</option>';
                            }

                            layouts.prepend(row);

                            for (let key in data) {
                                let page = data[key];
                                if (page != '??????') {
                                    let row = `<option value=${key}>${page}</option>`;
                                    layouts.append(row);
                                }
                            }
                        }

                        if(selectValue) {
                            $(`#layouts option:contains("${selectValue}")`).map(function(){ 
                                if ($(this).text() == selectValue) {
                                    return this;
                                }
                            }).prop("selected", "selected");
                        }
                        
                        layouts.change();
                    },
                    error: function (data) {
                        layer.alert("??????????????????????????????????????????????????????????????????", { icon: 2 });
                    }
                });
            }

            function saveLayout() {
                let columns = [];
                let selectValue = $('#layouts').find("option:selected").text();
                $('#columns .column').each((index: number, elem: Element) => {
                    let width = parseInt(elem.getAttribute('data-col'));
                    let configStr = elem.getAttribute('data-config');
                    let config = configStr && configStr.length > 0 ? JSON.parse(configStr) : {};

                    columns.push({
                        width: width,
                        config: config
                    });
                });

                $.ajax({
                    type: "POST",
                    url: `/manage/customization/${$('#layouts').val()}/${selectValue}/customization/add`,
                    contentType: "application/json",
                    data: JSON.stringify({ config: JSON.stringify(columns) }),
                    success: function (data) {
                        loadLayouts(false, selectValue);
                        layer.alert("????????????!", { icon: 1, time: 1500 });
                    },
                    error: function (e, xhr, opt) {
                        layer.alert("????????????! " + e.responseJSON.message, { icon: 2 });
                    }
                });
            }

            export function init() {
                $('#columns').sortable({
                    revert: true
                });
                $('#draggable').draggable({
                    connectToSortable: '#columns',
                    helper: function () {
                        let colSize = getColSize();
                        if (!isNaN(colSize)) {
                            return $(`<div class="col-sm-${colSize} column" data-col="${colSize}"></div>`);
                        } else {
                            return false;
                        }
                    },
                    revert: 'invalid',
                });

                $('#draggable').draggable('disable');

                $('#colSize').on('change', function () {
                    let colSize = getColSize();
                    if (!isNaN(colSize) && colSize <= 12 && colSize >= 1) {
                        $('#draggable').text('??????');
                        $('#draggable').draggable('enable');
                    } else {
                        $('#draggable').text('???????????????1???12?????????');
                        $('#draggable').draggable('disable');
                    }
                })

                $('#draggable').on('dragstop', function (event, ui) {
                    $(ui.helper).css('width', '');
                    $(ui.helper).css('height', '');
                });

                $('#columns').on('click', '.column', function () {
                    if ($(this).hasClass('selected')) {
                        $('.selected').removeClass('selected');
                    } else {
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
                        title: '????????????',
                        area: ['100%', '100%'],
                        content: '/page/dashboard/component.html?config=' + encodeURIComponent($.trim($('.selected').attr('data-config'))),
                        end: function (index, layero) {
                            initElement($('.selected'));
                        }
                    });
                });

                $('#copyColumn').on('click', function () {
                    let selected = $('.selected');
                    if (selected.length != 1) {
                        return;
                    }

                    let colSize = selected.attr('data-col');
                    let config = selected.attr('data-config');
                    let newCol = $(`<div class="col-sm-${colSize} column" data-col="${colSize}"></div>`);
                    newCol.attr('data-config', config);

                    selected.after(newCol);

                    initElement(newCol);
                });

                $('#zoomIn').on('click', function () {
                    $('.selected').each((index: number, elem: Element) => {
                        let colSize = parseInt(elem.getAttribute('data-col').trim());
                        if (!isNaN(colSize) && colSize < 12) {
                            elem.setAttribute('data-col', `${colSize + 1}`);
                            elem.className = elem.className.replace(`col-sm-${colSize}`, `col-sm-${colSize + 1}`);
                        }
                    });

                    initElement($('.selected'));
                });

                $('#zoomOut').on('click', function () {
                    $('.selected').each((index: number, elem: Element) => {
                        let colSize = parseInt(elem.getAttribute('data-col').trim());
                        if (!isNaN(colSize) && colSize > 1) {
                            elem.setAttribute('data-col', `${colSize - 1}`);
                            elem.className = elem.className.replace(`col-sm-${colSize}`, `col-sm-${colSize - 1}`);
                        }
                    });

                    initElement($('.selected'));
                });

                $('#newLayout').on('click', function () {
                    layer.prompt({
                        formType: 0,
                        title: "????????????????????????"
                    }, function (value, index, elem) {
                        layer.close(index);
                        let select = $('#layouts');

                        if ($(`#layouts option[text="${value}"]`).length == 0) {
                            select.append(`<option value='-1'>${value}</option>`);
                        } else {
                            layer.alert(`??????${value}????????????????????????.`, { icon: 2, time: 1500 });
                        }

                        select.val('-1');
                        select.change();
                    });
                });

                $('#copyLayout').on('click', function () {
                    layer.prompt({
                        formType: 0,
                        title: "????????????????????????"
                    }, function (value, index, elem) {
                        layer.close(index);
                        let select = $('#layouts');
                        select.append(`<option value=${value}>${value}</option>`);
                        select.val(value);
                        saveLayout();
                    });
                });

                var loadSelectUserGroups = function() {
                    $.get(`/customization/${$("#layouts").val()}/assigned`).done(function(groups) {
                        let userGroups = [];

                        groups.forEach(element => {
                            userGroups.push(element.groupId);
                        });

                        $.ajax({ url: "/usergroups?pageSize=" + common.utils.maxPageSize, success: function(data){
                            var select = $("#selectUserGroups");
                            select.empty();
                            for (var i=0;i<data.length;i++)
                            {
                                var rowData = data[i];
                        
                                if ($.inArray(rowData.id, userGroups) == -1) {
                                    var row = '<option value="' + rowData.id + '">' + rowData.groupName + '</option>';
                                    select.append(row);
                                }
                            }
                        }});
                    })
                };

                $('#shareLayout').on('click', function () {
                    let type = $('#layouts').find("option:selected").text();
                    if(type == '??????'){
                        layer.alert(`?????????????????????????????????.`, { icon: 2, time: 1500 });
                        return;
                    }

                    loadSelectUserGroups();

                    $("#sharename").text(type);
                    
                    $('#userGroupsModal').modal('show');
                });

                $("#saveUserGroupsButton").on("click", function() {
                    let selectUserGroups = $("#selectUserGroups").val();
                    if(!selectUserGroups){
                        layer.alert("???????????????????????????! ", {icon: 2});
                        return;
                    }
                    $.ajax({
                        type:"POST",
                        url: `/manage/customization/${$("#layouts").val()}/customization/share`,
                        contentType:"application/json",
                        data:JSON.stringify(selectUserGroups),
                        success: function(data){
                            layer.alert("????????????!", {icon: 1, time : 1500});
                            $('#userGroupsModal').modal('hide');
                        },
                        error: function(e,xhr,opt){
                            layer.alert("????????????! " + e.responseJSON.message, {icon: 2});
                        }
                    });
                });

                $('#layouts').on('change', function () {
                    loadLayout($(this).val());
                })

                $('#saveLayout').on('click', function () {
                    let type = $('#layouts').find("option:selected").text();
                    layer.confirm("??????????????????'" + type + "'", {icon: 3, title: "???????????????"}, function(index){
                        saveLayout();
                    });
                });

                $('#deleteLayout').on('click', function () {
                    let layout = $("#layouts").val();
                    let type = $('#layouts').find("option:selected").text();
                    layer.confirm("??????????????????'" + type + "'", {icon: 3, title: "???????????????"}, function(index){
                        $.get(`/manage/customization/${$("#layouts").val()}/customization/remove`).done(function () {
                            layer.alert("??????????????????????????????", { icon: 1, time: 1500 });
                            loadLayouts(false);
                        });
                    });
                });

                $("#shareManageLayout").on("click", function() {
                    layer.open({
                        type: 2,
                        title: '????????????',
                        area: ['100%', '100%'],
                        content: 'sharemanage.html',
                        scrollbar: false
                    });
                });

                loadLayouts(false);
            }
        }
    }
}