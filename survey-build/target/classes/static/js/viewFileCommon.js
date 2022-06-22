var wwIpAddress = "117.71.60.217";
var localIp = document.location.host.split(":")[0];
var configPrefix = "house.file.";
var configPrefixFileUrl = "house.file.url";
var configPrefixServer = "house.file.serverurl";
var configPrefixWebAddr = "house.file.webAddrURL";

function isEmpty(value) {
    if (value == null || trim(value) == "" || trim(value) == "null") {
        return true;
    }
    return false;
}

// 空格截取
function trim(value) {
    if (value == null) {
        return "";
    }
    return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
}

function viewfile(fileId,fileType) {
    $.ajax({ url:"/configs/names/" + configPrefixWebAddr , success: function(url){
        if(!isEmpty(url[0].value)){
            wwIpAddress = url[0].value;
        }
    
        $.ajax({ url:"/configs/names/" + configPrefix , success: function(data){
            if(!data){
                return ;
            }

            var arr = fileId.split(",");
            var url = "";
            var downfileUrl = "";
            var serviceUrl = "";

            if(configPrefixFileUrl == data[0].name){
                downfileUrl = data[0].value;
                serviceUrl = data[1].value;
            }else{
                downfileUrl = data[1].value;
                serviceUrl = data[0].value;
            }

            if(localIp == wwIpAddress){
                downfileUrl = localIp + ":9080";
                serviceUrl = localIp + ":8012";
            }

            if(arr.length === 1){
                var file = "http://" + downfileUrl + "/open/files/"+fileId;
                //service[0].value  :8012
                url = "http://" + serviceUrl + "/onlinePreview?url=" + encodeURIComponent(file) + "&fileType=" + fileType;
            }else{
                var urls = "";
                for (i=0;i<arr.length ;i++ )
                {
                    if(i === arr.length - 1){
                        urls += "http://" + downfileUrl + "/open/files/" + arr[i];
                    }else{
                        urls += "http://" + downfileUrl + "/open/files/" + arr[i] + "|";
                    }
                }

                url = "http://" + serviceUrl + "/picturesPreview?urls=" + encodeURIComponent(urls) + "&currentUrl=http://localhost:9080";

            }

            var winHeight = window.document.documentElement.clientHeight-10;
            window.open(url, "_blank", "height=" + winHeight
                    + ",top=80,left=80,toolbar=no, menubar=no, scrollbars=yes, resizable=yes");
        }})

    }})
}

function viewJpgFile(fileIds, fileType) {
    $.ajax({ url:"/configs/names/" + configPrefixWebAddr , success: function(url){
        if(!isEmpty(url[0].value)){
            wwIpAddress = url[0].value;
        }
        $.ajax({ url:"/configs/names/" + configPrefix , success: function(data){
            var urls = '';
            var fileServiceUrl = "";
            var localUrl = "";

            if(configPrefixFileUrl == data[0].name){
                localUrl = data[0].value;
                fileServiceUrl = data[1].value;
            }else{
                localUrl = data[1].value;
                fileServiceUrl = data[0].value;
            }

            if(localIp == wwIpAddress){
                localUrl = "127.0.0.1:9080";
                fileServiceUrl = localIp + ":8012";
            }

            $.each(fileIds, function(index, value){
                if(index === fileIds.length - 1){
                    urls += "http://" + localUrl + "/open/files/" + value['fileId'];

                    return true;
                }
                urls += "http://" + localUrl + "/open/files/" + value['fileId'] + "|";
            });

            var url = "http://" + fileServiceUrl + "/picturesPreview?urls=" + encodeURIComponent(urls) + "&currentUrl=http://" + localUrl;
            var winHeight = window.document.documentElement.clientHeight-10;
            window.open(url, "_blank", "height=" + winHeight
                    + ",top=10,left=80,bottom= 10,toolbar=no, menubar=no, scrollbars=yes, resizable=yes");
        }});
    }});
}

function downloadFile(fileId){
	if(fileId){
		self.location.href="/open/files/"+fileId;
	}
}