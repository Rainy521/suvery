var maxPageSize = 2147483647;
var chartId = '';
var chartStyle = '';
var apiServiceBaseUri = 'http://127.0.0.1:8080/';

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function isFormValid(name) {
    var form = $('#' + name);
    
    var formData = form.data('bootstrapValidator');
    
    formData.validate();
    
    return formData.isValid();
}

function resetForm(name) {
    var form = $('#' + name);
    form[0].reset();
    form.find("input:disabled").removeAttr("disabled");
    form.find("input[type=hidden]").val('');
    form.bootstrapValidator("resetForm", true);
}

function pagination(total, pageNum, pageSize) {
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
    
    var pagination = $("#pagination");
    pagination.empty();
    pagination.append('<button class="btn btn-white">共' + total + '条</button>');
    
    if (totalPage > 1) {
        pagination.append('<button class="btn btn-white pageBtn" type="button" data="' + last + '"><i class="fa fa-chevron-left"></i></button>');
        for (var i=begin; i <= end; i++) {
            if (i == pageNum) {
                pagination.append('<button class="btn btn-white pageBtn active" data="' + i + '">' + i + '</button>');
            } else {
                pagination.append('<button class="btn btn-white pageBtn" data="' + i + '">' + i + '</button>');
            }
        }
        pagination.append('<button class="btn btn-white pageBtn" type="button" data="' + next + '"><i class="fa fa-chevron-right"></i> </button>');
    }
}

function defaultV(value, defaultValue) {
    return typeof value !== 'undefined' ? value : defaultValue;
}

function esquery_escape(value, wildcard) {
    var reservedCharacters = '+-=&&||><!(){}[]^"~*?:\\/';
    
    var escapeValue = '';
    for (var i in value) {
        var c = value[i];
        if (reservedCharacters.indexOf(c) > -1) {
            escapeValue += '\\';
        }
        
        escapeValue += c;
    }
    
    if(wildcard !== undefined){
        return escapeValue + wildcard;
    }
    
    return '"' + escapeValue +'"';
}

function strip_special(value) { 
    var reservedCharacters = " [\"%+_《》`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]";
    var rs = ""; 
    for (var i in value) { 
        var c = value[i];
        if (reservedCharacters.indexOf(c) > -1) {
            continue;
        }
        rs = rs + c;
    }
    
    return rs; 
}

var constants = {
    dayRange : {
        '今天': [moment().startOf('day'), moment().startOf('day').add(1, 'days')],
        '昨天': [moment().startOf('day').subtract(1, 'days'), moment().startOf('day')],
        '最近一周': [moment().startOf('day').add(-6, 'days'), moment().startOf('day').add(1, 'days')],
        '上周': [moment().startOf('week').subtract(1, 'week'), moment().startOf('week')],
     },
}

function daterangepicker($this, startDate, endDate, ranges) {
    var dateRange = $('<div class="input-group calendar">'
            + '<span class="input-group-addon"><i class="fa fa-calendar"></i></span>'
            + '<input type="text" class="form-control dateRange calendar">'
        + '</div>');
    
    $this.append(dateRange);
    
    dateRange = $this.find(".dateRange");
    
    initDateRangePicker(dateRange, startDate, endDate, ranges);
    
    return dateRange;
}

function initDateRangePicker(dateRange, startDate, endDate, ranges, single, format) {
    if(!ranges){
        ranges = constants.dayRange;
    }
    
    dateRange.daterangepicker({
        startDate: startDate,
        endDate: endDate,
        singleDatePicker: single,
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true,
        timePickerIncrement: 1,
        locale: {
            format: format?format : 'YYYY/MM/DD HH:mm:ss',
            customRangeLabel: "自定义",
            applyLabel: "确定",
            cancelLabel: "取消"
        },
        ranges: ranges
    });
    
    return dateRange;
}

function getDateRange(dateRangePicker) {
    var dateRange = dateRangePicker.val();
    
    var dates = dateRange.split("-")
    var startDate = moment($.trim(dates[0]), 'YYYY/MM/DD HH:mm:ss');
    var endDate = moment($.trim(dates[1]), 'YYYY/MM/DD HH:mm:ss');
    
    return [startDate, endDate];
}

function getDateRangeByDate(startDate, endDate) {
    
    startDate = moment(startDate, 'YYYY/MM/DD HH:mm:ss');
    endDate = moment(endDate, 'YYYY/MM/DD HH:mm:ss');
    
    return [startDate, endDate];
}

function getDateRangeCondition(startDate, endDate, dateField) {
    if (dateField) {
        return " +" + dateField + ":[\"" + startDate.format("YYYY-MM-DD HH:mm:ss") + "\" TO \"" + endDate.format("YYYY-MM-DD HH:mm:ss") + "\"}";
    } else {
        return " +timestamp:[\"" + startDate.format("YYYY-MM-DD HH:mm:ss") + "\" TO \"" + endDate.format("YYYY-MM-DD HH:mm:ss") + "\"}";
    }
}

function getDateRangeConditionByPicker(dateRangePicker, dateField) {
    var dateRange = getDateRange(dateRangePicker);
    
    return getDateRangeCondition(dateRange[0], dateRange[1], dateField);
}

function utcToLocal(value) {
    if (value.indexOf("T") > 0) {
        return moment(value).local().format("YYYY-MM-DD HH:mm:ss");
    }
    return moment(value).add(8, 'hours').format("YYYY-MM-DD HH:mm:ss");
}

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
    } else {
        return value;
    }
}

//编辑按钮，初始化chart配置
function initChartConfig(button){
  chartId = $(button).parent().next().next().children().last().attr('id');
  chartStyle = chartId.split('-')[0];
  $("#" + chartStyle + "Modal").modal("show");
  
  $('#' + chartStyle + 'Form').setForm(JSON.parse($(".demo #Back" + chartId).attr("data-config")));
}

function getRangesScript(config){
    if (config) {
        config.startDate = eval(config.startDate);
        config.endDate = eval(config.endDate);
    }
    
    return config;
}

function setFromValues(el, data)
{
    for (var p in data)
    {
        el.find(":input[name='" + p + "']").val(data[p]);
    } 
}

var orderType;
var orderField;

function getOrder(table, callback){
    $(table).on('click', 'thead tr span', function (event) {
        orderField = event.target.firstChild.innerHTML;
        var firstIndex = orderField.indexOf('.');
        
        $("th span").not($(this)).attr('class', 'table-sort table-default-icon');
        if($(this).hasClass("table-sort table-desc-icon")){
            $(this).attr('class', 'table-sort table-asc-icon');
            orderType = 'ASC';;
        }else{
            $(this).attr('class', 'table-sort table-desc-icon')
            orderType = 'DESC';;
        }
        
        if(firstIndex != -1){
            orderField = orderField.substr(firstIndex + 1, orderField.length);
        }
        
        orderField = orderField;
        callback();
    });
}

function guid() {
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
}

function addIframe(obj,iframes,title) {
    var o = $(obj).data("href")
      , m = $(obj).data("index")
      , k = true;
    if (o == undefined || $.trim(o).length == 0) {
        return false
    }
    $(iframes).find(".J_menuTab").each(function() {
        if ($(this).data("id") == o) {
            if (!$(this).hasClass("active")) {
                $(this).addClass("active").siblings(".J_menuTab").removeClass("active");
                outerWidth(this);
                $(iframes).find(".J_mainContent .J_iframe").each(function() {
                    if ($(this).data("id") == o) {
                        $(this).show().siblings(".J_iframe").hide();
                        return false
                    }
                })
            }
            k = false;
            return false
        }
    });
    if (k || o.indexOf("mutipartOpen") > 0) {
        if (o.indexOf("mutipartOpen") > 0) {
            o = o + guid()
        }
        
        if($(iframes).find(".J_mainContent").length == 0){
            window.open(o);
            return false;
        }
        
        var p = '<a href="javascript:;" class="active J_menuTab" data-id="' + o + '">' + title + '<i class="fa fa-times-circle"></i></a>';
        $(iframes).find(".J_menuTab").removeClass("active");
        var n = '<iframe class="J_iframe" name="iframe' + m + '" width="100%" height="100%" src="' + o + '" frameborder="0" data-id="' + o + '" seamless></iframe>';
        $(iframes).find(".J_mainContent").find("iframe.J_iframe").hide().parents(".J_mainContent").append(n);
        $(iframes).find(".J_menuTabs .page-tabs-content").append(p);
        outerWidth($(iframes).find(".J_menuTab.active"))
    }
    return false
}

function outerWidth(n, iframes) {
    var o = counter($(n).prevAll())
      , q = counter($(n).nextAll());
    var l = counter($(iframes).find(".content-tabs").children().not(".J_menuTabs"));
    var k = $(iframes).find(".content-tabs").outerWidth(true) - l;
    var p = 0;
    if ($(iframes).find(".page-tabs-content").outerWidth() < k) {
        p = 0
    } else {
        if (q <= (k - $(n).outerWidth(true) - $(n).next().outerWidth(true))) {
            if ((k - $(n).next().outerWidth(true)) > q) {
                p = o;
                var m = n;
                while ((p - $(m).outerWidth()) > ($(iframes).find(".page-tabs-content").outerWidth() - k)) {
                    p -= $(m).prev().outerWidth();
                    m = $(m).prev()
                }
            }
        } else {
            if (o > (k - $(n).outerWidth(true) - $(n).prev().outerWidth(true))) {
                p = o - $(n).prev().outerWidth(true)
            }
        }
    }
    $(iframes).find(".page-tabs-content").animate({
        marginLeft: 0 - p + "px"
    }, "fast")
}

function counter(l) {
    var k = 0;
    $(l).each(function() {
        k += $(this).outerWidth(true)
    });
    return k
}

function initMesage(){
    jQuery.validator.addMethod("phone", function(C, A) {
        var B = /^(0|86|17951)?(19[0-9]|13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写您的手机号码");
    jQuery.validator.addMethod("fox", function(C, A) {
        var B = /((^\d{11}$)|(^\d{12}$))|(^\d{3}-\d{8}$)|(^\d{4}-\d{7}$)|(^\d{4}-\d{8}$)/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写您的传真号码");
    jQuery.validator.addMethod("url", function(C, A) {
        //var B = /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
        return this.optional(A) || (B.test(C))
    }, "请输入正确的网址，例如：https://www.baidu.com/");
    jQuery.validator.addMethod("price", function(C, A) {
        var B = /^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
        return this.optional(A) || (B.test(C))
    }, "价格填写不符合格式(<100亿,两位小数)");
    jQuery.validator.addMethod("space", function(C, A) {
        var B = /^[\S]*$/;
        return this.optional(A) || (B.test(C))
    }, "不能输入空格！");
    jQuery.validator.addMethod("telephone", function(C, A) {
        var B = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写固定电话号码<br/>(格式为:区号-电话号码)");
    jQuery.validator.addMethod("payPrice", function(C, A) {
        var B = /^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
        return this.optional(A) || (B.test(C))
    }, "金额填写错误");
    jQuery.validator.addMethod("data", function(C, A) {
        var B = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
        return this.optional(A) || (B.test(C))
    }, "日期填写错误");
    jQuery.validator.addMethod("postCode", function(C, A) {
        var B = /^[1-9]\d{5}(?!\d)$/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写您的邮政编码");
    jQuery.validator.addMethod("englishCode", function(C, A) {
        var B = /^[A-Za-z ]+$/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写英文信息");
    jQuery.validator.addMethod("chinaCode", function(C, A) {
        var B = /^[\u4e00-\u9fa5](\s*[\u4e00-\u9fa5])*$/;
        return this.optional(A) || (B.test(C))
    }, "请正确填写汉字");
    jQuery.validator.addMethod("bankCode", function(C, A) {
        var B = /^\d{16,}$/;
        return this.optional(A) || (B.test(C))
    }, "请正确的银行卡号");
    jQuery.validator.addMethod("zcsCode", function(C, A) {
        var B = /^[1-9]|[1-9][0-9]*$/;
        return this.optional(A) || (B.test(C))
    }, "请输入正确的总层数");
    jQuery.validator.addMethod("fcsCode", function(C, A) {
        var B = /^[1-9]\d*|0$/;
        return this.optional(A) || (B.test(C))
    }, "请输入正确的层数");
}

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name] += "," + this.value; //.push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    var $radio = $('input[type=radio],input[type=checkbox]',this);
    $.each($radio,function(){
        if(!o.hasOwnProperty(this.name)){
            o[this.name] = '';
        }
    });
    return o;
};

$.fn.setForm = function(jsonValue) {  
    var obj = this;  
    $.each(jsonValue, function (name, ival) {  
        var $oinput = obj.find("[name=" + name + "]");   
        if ($oinput.attr("type")== "radio" || $oinput.attr("type")== "checkbox"){  
             $oinput.each(function(){  
                 if(Object.prototype.toString.apply(ival) == '[object Array]'){//是复选框，并且是数组  
                      for(var i=0;i<ival.length;i++){  
                          if($(this).val()==ival[i])  
                             $(this).attr("checked", "checked");  
                      }  
                 }else{  
                     if($(this).val()==ival)  
                        $(this).attr("checked", "checked");  
                 }  
             });  
        }else if($oinput.attr("type")== "textarea"){//多行文本框  
            obj.find("[name="+name+"]").html(ival);  
        }else{  
             obj.find("[name="+name+"]").val(ival);   
        }  
   });  
};

$.isEmptyObject = function(obj){
      var name;
      for ( name in obj ) {
        return false;
      }
      return true;
    }

$(document).ready(function() {
    $.ajaxSetup(
    {
        dataType: "json",
        dataFilter: function(data, type){
            if (data == "" && type == "json") {
                data = "{}";
            }
            
            return data;
        },
        error: function(jqXHR, textStatus, errorMsg){
            if (textStatus == 'parsererror' && jqXHR.responseText.startsWith('<!DOCTYPE html>')) {
                window.location.reload();
                return;
            }
            
            if (jqXHR.responseJSON) {
                layer.alert(jqXHR.responseJSON.message, {icon: 2});
            } if (jqXHR.responseText) {
                try {
                    layer.alert(JSON.parse(jqXHR.responseText).message, {icon: 2});
                } catch(e) {
                    layer.alert(jqXHR.responseText, {icon: 2});
                }
            } else {
                layer.alert('发送请求到"' + decodeURIComponent(this.url) + '"时出错[' + jqXHR.status + ']' + errorMsg, {icon: 2});
            }
        }
    });
    
    $(document).on('show.bs.modal', function (e) {
        $(this).find('form').each(function() {
            var form = $(this);
            var bootstrapValidatorData = form.data('bootstrapValidator');
            if (bootstrapValidatorData != null) {
                bootstrapValidatorData.destroy();
                form.data('bootstrapValidator', null);
            }
            
            form.bootstrapValidator({excluded: [':disabled']});
        });
    });
    
    $(document).on("blur", "input", function (e) {
        $(this).val($.trim($(this).val()));
    });
});

$('div').on('mouseover','.divmatnrdesc', function(e) {
    _text=$(this).text();
  _tooltip = "<div id='tooltipdiv'><font style='font-size:13px'> "+_text+"</font></div>";  
      $("body").append(_tooltip);  
      $("#tooltipdiv").show();
   $("#tooltipdiv")
   .css({
   "top": (e.pageY+10) + "px",
   "left":  (e.pageX +10) + "px"
  }).show("fast");    
});
 
$('div').on('mouseout','.divmatnrdesc', function(e) {
  $("#tooltipdiv").remove();
});
 
 
$('div').on('mousemove','.divmatnrdesc', function(e) {
  $("#tooltipdiv")
  .css({
   "top": (e.pageY+10 ) + "px",
   "left":  (e.pageX+10)  + "px"
  }).show();    
});
