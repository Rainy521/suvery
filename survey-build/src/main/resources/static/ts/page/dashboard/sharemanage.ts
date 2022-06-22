namespace page {
    export namespace dashboard {
        export namespace sharemanage {
            declare var layer;

            export function init() {

                $("#customizations").on("click", ".deleteButton", function() {
                    var row = $(this).parent().parent();
                    var customizationIdTD = row.children().first();
                    var customizationId = customizationIdTD.text();
                    var userNameTd = customizationIdTD.next();
                    var typeTd = userNameTd.next();
                    var type = typeTd.text();
                    
                    layer.confirm("仪表盘类型为‘" + type + "'", {icon: 3, title: "删除共享仪表盘"}, function(index){
                        $.ajax({
                            type:"GET",
                            url: "/manage/customization/" + customizationId + "/share/remove",
                            success: function(data){
                                        layer.alert("删除成功!", {icon: 1, time : 1500});
                                        loadShare();
                                    },
                            error: function(e,xhr,opt){
                                layer.alert("删除失败! " + e.responseJSON.message, {icon: 2});
                            }
                        });
                        
                        layer.close(index);
                    });
                });

                loadShare();
            }

            function loadShare() {
                $.get('/customization/share').done(function(data) {
                   var table = $("#customizations");
                    table.empty();
                    for (var i=0;i<data.length;i++)
                    {
                        var rowData = data[i];
                        var row = "<tr><td>" + rowData.customizationId + "</td><td>" + rowData.username + "</td><td>" + rowData.type + "</td>"
                                    + '<td><button type="button" class="btn btn-danger btn-xs deleteButton">删除</button></td>'
                                    + '</tr>';
                        table.append(row);
                    }
                })
            }
        }
    }
}
