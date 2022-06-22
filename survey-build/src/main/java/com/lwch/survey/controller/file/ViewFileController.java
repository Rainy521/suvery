package com.lwch.survey.controller.file;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.httpclient.HttpClientUtil;
import com.lwch.survey.model.Config;
import com.lwch.survey.service.ConfigService;

@RestController
@RequestMapping("/view/files")
public class ViewFileController {

	@Autowired
    private ConfigService configService;
	
	@Autowired
	private HttpClientUtil httpClientUtil;
    
    @GetMapping("/file")
    public CloseableHttpResponse viewFilePage(@RequestParam(required = false) String fileId, 
    		@RequestParam(required = false) String fileType) throws Exception  {
    	
    	Config localIp = configService.selectConfig("house.file.url");
    	Config viewIp = configService.selectConfig("house.file.serverurl");
    	if(null == localIp || null == viewIp) {
    		return null;
    	}
    	//url=" + localIp.getValue() + "/open/files/" + fileId + "&fileType=" + fileType
    	String url = "http://" + viewIp.getValue() + "/onlinePreview";
    	
    	Map<String, String> headers = new HashMap<>();
    	headers.put("url", "http://" + localIp.getValue() + "/open/files/" + fileId);
    	headers.put("fileType", fileType);
    	
    	
    	return httpClientUtil.getRequest(url, null, headers);
    	
    }
}
