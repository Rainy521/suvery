(function($) {
    var settings;

    function createTable(dataKeys, datas) {
        var table = $('<table class="table table-bordered table-hover" />');
        
        {
            var thead = '<thead><tr>';
            for (var i in dataKeys) {
                if(dataKeys[i].hidden){
                    thead = thead + '<th hidden>' + dataKeys[i].title + '</th>';
                }
                else if(sortArray[dataKeys[i].field]){
                    thead = thead + '<th><font color="#4081c0">' + dataKeys[i].title + '</font><span class="'+sortArray[dataKeys[i].field]+'"><p style="display:none;">'+ dataKeys[i].field +'</p></span></th>';
                }
                else{
                    thead = thead + '<th>' + dataKeys[i].title + '<span class="table-sort table-default-icon"><p style="display:none;">'+ dataKeys[i].field +'</p></span></th>';
                }
            }
            thead = thead + '</tr></thead>';
            
            table.append(thead);
        }
        
        {
            var tbody = '<tbody>';
            for (var i in datas) {
                var tr = '<tr>';
                for (var j in dataKeys) {
                    var key = dataKeys[j].field;
                    var data = datas[i];
                    
                    if(key.indexOf('.') != -1){
                        var keyArry = key.split('.');
                        for(var k in keyArry){
                            data = data[keyArry[k]];
                        }
                    }else{
                        data = data[key];
                    }
                    
                    if(dataKeys[j].hasOwnProperty("formatter")) {
                        data = dataKeys[j].formatter(data);
                    }
                    
                    if(dataKeys[j].hidden){
                        tr = tr + '<td hidden>' + data + '</td>';
                    }else{
                        tr = tr + '<td>' + data + '</td>';
                    }
                }
                tr = tr + '</tr>';
                
                tbody = tbody + tr;
            }
            tbody = tbody + '</tbody>';
            
            table.append(tbody);
        }
        
        table.on('click', 'tbody tr', function (event) {
            var tr = event.currentTarget;
            
            table.find('tbody tr').removeClass('info');
            
            $(tr).addClass('info');
            
            settings.onclick(tr);
        });
        
        table.on('dblclick', 'tbody tr', function (event) {
            var tr = event.currentTarget;
            
            table.find('tbody tr').removeClass('info');
            
            $(tr).addClass('info');
            
            settings.dblclick(tr);
        });
        
        return table;
    }
    
    function createPagination(total, pageNum, pageSize) {
        var totalPage = Math.ceil(total / pageSize);
        
        var last = pageNum - 1;
        if (last < 1) {
            last = 1;
        }
        
        var next = pageNum + 1;
        if (next > totalPage) {
            next = totalPage;
        }
        
        var begin = pageNum - 4;
        if (begin < 1) {
            begin = 1;
        }
        
        var end = begin + 9;
        if (end > totalPage) {
            end = totalPage;
        }
        
        var pagination = $('<div class="btn-group"/>');
        
        if (totalPage > 1) {
            pagination.append('<button class="btn btn-white pageBtn" data="' + last + '"><i class="fa fa-chevron-left"></i></button>');
            for (var i = begin; i <= end; i++) {
                if (i == pageNum) {
                    pagination.append('<button class="btn btn-white pageBtn active" data="' + i + '">' + i + '</button>');
                } else {
                    pagination.append('<button class="btn btn-white pageBtn" data="' + i + '">' + i + '</button>');
                }
            }
            pagination.append('<button class="btn btn-white pageBtn" data="' + next + '"><i class="fa fa-chevron-right"></i> </button>');
        }
        
        return $('<div class="text-center">').append(pagination);
    }
    
    function loadData($this, tableDiv, dateRangePicker, pageNum) {
        settings = $this.data("settings");
        
        var q = settings.q + getDateRangeConditionByPicker(dateRangePicker, settings.dateField);
        
        var url = '/search/' + settings.index + '/' + settings.type + '/?q=' + encodeURIComponent(q) + '&pageNum=' + pageNum + '&pageSize=' + settings.pageSize + '&orderField=' + settings.orderField + '&orderType='+settings.orderType;
        
        var oldChildren = tableDiv.children();
        
        $.get(url).done(function (data) {
            tableDiv.append('<h3>找到相关结果约<strong>' + data.hits.total + '</strong>个</h3>');
            tableDiv.append('<small>耗时 (<strong>' + data.took / 1000 + '</strong> 秒)</small>');
            
            tableDiv.append(createTable(settings.dataKeys, data.hits.hits));
            
            tableDiv.append('<div class="hr-line-dashed"></div>');
            
            var pagination = createPagination(data.hits.total, pageNum, settings.pageSize);
            pagination.on("click", ".pageBtn", function() {
                loadData($this, tableDiv, dateRangePicker, parseInt($(this).attr("data")));
            });
            
            tableDiv.append(pagination);
            oldChildren.remove();
        });
    }
    
    $.fn.table = function(options) {
        var defaults = {
            index: '',
            type: '_all',
            q: '',
            startDate: moment().startOf('day'),
            endDate: moment().startOf('day').add(1, 'days'),
            dateField: '',
            dataKeys: [],
            pageSize:10,
            orderField: '',
            orderType: '',
            onclick: function(tr) {
            },
            dblclick: function(tr) {
            }
        };
        var settings = $.extend({}, defaults, options || {});
        
        var $this = $(this);
        
        $this.data("settings", settings);
        
        var dateRangePicker = daterangepicker($this, settings.startDate, settings.endDate);
        
        var tableDiv = $('<div></div>').appendTo($this);
        
        var load = function() {
            sortArray = [];
            loadData($this, tableDiv, dateRangePicker, 1);
        }
        
        load();
        
        dateRangePicker.on('apply.daterangepicker',function(event, picker) {
            load();
        });
        
        $this.on('click', 'thead tr span', function (event) {
            var orderField = event.target.firstChild.innerHTML;
            var firstIndex = orderField.indexOf('.');
            
            sortArray = [];
            
            if($(this).hasClass("table-sort table-desc-icon")){
                sortArray[orderField] = "table-sort table-asc-icon";
                settings.orderType = 'ASC';;
            }else{
                sortArray[orderField] = "table-sort table-desc-icon";
                settings.orderType = 'DESC';;
            }
            
            if(firstIndex != -1){
                orderField = orderField.substr(firstIndex + 1, orderField.length);
            }
            
            settings.orderField = orderField;
            loadData($this, tableDiv, dateRangePicker, 1);
        });
        
        return this;
    };
})(jQuery);
