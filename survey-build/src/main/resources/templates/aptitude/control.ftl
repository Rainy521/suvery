
    /*设置控件*/
    $('#form #expiryTime').daterangepicker({
        singleDatePicker: true,//设置为单个的datepicker，而不是有区间的datepicker 默认false
        showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
        autoUpdateInput: true,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
        timePicker24Hour : true,//设置小时为24小时制 默认false
        timePicker :true,//可选中时分 默认false
        locale: {
            applyLabel: "确定",
            cancelLabel: "取消",
            format: "YYYY-MM-DD",
            separator: " - ",
            daysOfWeek: ["日","一","二","三","四","五","六"],
            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
        }
    }).on('cancel.daterangepicker', function(ev, picker) {
        $('#expiryTime').val('')
    })
   
    $('#expiryTime').val('');
   
    $('#verificationDate').daterangepicker({
        singleDatePicker: true,//设置为单个的datepicker，而不是有区间的datepicker 默认false
        showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
        autoUpdateInput: true,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
        timePicker24Hour : true,//设置小时为24小时制 默认false
        timePicker :true,//可选中时分 默认false
        locale: {
            applyLabel: "确定",
            cancelLabel: "取消",
            format: "YYYY-MM-DD",
            separator: " - ",
            daysOfWeek: ["日","一","二","三","四","五","六"],
            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
        }
    }).on('cancel.daterangepicker', function(ev, picker) {
        $('#instrumentForm').data('bootstrapValidator').updateStatus('verificationDate', 'NOT_VALIDATED').validateField('verificationDate');
    }).on('hide.daterangepicker', function(ev, picker) {
        $('#instrumentForm').data('bootstrapValidator').updateStatus('verificationDate', 'NOT_VALIDATED',null).validateField('verificationDate');
    })

    $('#verificationDate').val('');
   
    $('#emplyeeExpiryTime').daterangepicker({
        singleDatePicker: true,//设置为单个的datepicker，而不是有区间的datepicker 默认false
        showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
        autoUpdateInput: true,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
        timePicker24Hour : true,//设置小时为24小时制 默认false
        timePicker :true,//可选中时分 默认false
        locale: {
            applyLabel: "确定",
            cancelLabel: "取消",
            format: "YYYY-MM-DD",
            separator: " - ",
            daysOfWeek: ["日","一","二","三","四","五","六"],
            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
        }
    }).on('hide.daterangepicker', function(ev, picker) {
        $('#userForm').data('bootstrapValidator').updateStatus('emplyeeExpiryTime', 'NOT_VALIDATED',null).validateField('emplyeeExpiryTime');
    }).on('cancel.daterangepicker', function(ev, picker) {
        $('#userForm').data('bootstrapValidator').updateStatus('emplyeeExpiryTime', 'NOT_VALIDATED').validateField('emplyeeExpiryTime');
    })
    
    $('#emplyeeExpiryTime').val('');
   
    var ary = new Array();
    (function (fileInputId, fileField, validate) {
        $("#" + fileInputId).fileinput({
            language: 'zh', //设置语言
            allowedFileExtensions: ['jpg'],//接收的文件后缀
            uploadAsync: true, //默认异步上传
            showUpload: false, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : true, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            uploadUrl: '/files/insert'
        }).on("filebatchselected", function(event, files) {
            ary = [];
            $(this).fileinput("upload");
        }).on('filecleared', function(event) {
            $("#" + fileField).val("");
            ary = [];
            $("#" + fileField + "Download").hide();
        }).on("fileuploaded", function(event, data) {
            if(data.response) {
                ary.push(data.response)
                $("#" + fileField).val(ary);
                $("#" + fileField + "Download").hide();
            }
        });
    })("input-configfiles", "configFiles"); 
   
    var ins = new Array();
    (function (fileInputId, fileField, validate) {
        $("#" + fileInputId).fileinput({
            language: 'zh', //设置语言
            allowedFileExtensions: ['jpg'],//接收的文件后缀
            uploadAsync: true, //默认异步上传
            showUpload: false, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : true, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            uploadUrl: '/files/insert'
        }).on("filebatchselected", function(event, files) {
            $(this).fileinput("upload");
            ins = [];
        }).on('filecleared', function(event) {
            $("#" + fileField).val("");
            ins = [];
            $("#" + fileField + "Download").hide();
        }).on("fileuploaded", function(event, data) {
            if(data.response) {
                ins.push(data.response)
                $("#" + fileField).val(ins);
                $("#" + fileField + "Download").hide();
            }
        });
    })("input-configfs", "configfs"); 
   
   
    var qs = new Array();
    (function (fileInputId, fileField, validate) {
        $("#" + fileInputId).fileinput({
            language: 'zh', //设置语言
            allowedFileExtensions: ['jpg'],//接收的文件后缀
            uploadAsync: true, //默认异步上传
            showUpload: false, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : false, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            uploadUrl: '/files/insert'
        }).on("filebatchselected", function(event, files) {
            $(this).fileinput("upload");
            qs = [];
        }).on('filecleared', function(event) {
            $("#" + fileField).val("");
            qs = [];
            $("#" + fileField + "Download").hide();
        }).on("fileuploaded", function(event, data) {
            if(data.response) {
                qs.push(data.response)
                $("#" + fileField).val(qs);
                $("#" + fileField + "Download").hide();
            }
        });
    })("input-files", "files"); 
