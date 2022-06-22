package com.lwch.survey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lwch.survey.model.File;
import com.lwch.survey.service.FileService;
import com.lwch.survey.utils.TimeUtils;

@RestController
@RequestMapping("/files")
public class FileController {
    
    @Autowired
    private FileService fileService;
    
    private Logger loger = LoggerFactory.getLogger(FileController.class);

    @PostMapping
    public Map<String, String> post(@RequestParam MultipartFile file) throws IOException {
        String id = UUID.randomUUID().toString();

        File f = new File();
        f.setId(id);
        f.setName(file.getOriginalFilename());
        f.setContent(file.getBytes());

        fileService.insertFile(f);

        return Collections.singletonMap("id", id);
    }
    
    @RequestMapping("/insert")
    public List<String> insert(@RequestParam MultipartFile[] file) throws Exception{
        
        List<String> fileids =new ArrayList<>();
        
        for(MultipartFile member : file){
            if (!member.isEmpty()) {
            	StringBuilder timeid = new StringBuilder(TimeUtils.getDatePrimaryKey());
            	
	    		try {
	    			String filename = member.getOriginalFilename();
	    			int endIdx = filename.lastIndexOf(FileService.SUBFILENAME_END);
					Integer.valueOf(filename.substring(0, endIdx));
					timeid.append("-");
		    		timeid.append(filename.substring(0, endIdx)); 
				} catch (Exception e) {
					loger.info(e.getStackTrace().toString());
				}
            	
                String id = timeid.toString();
                
                File f = new File();
                f.setId(id);
                f.setName(member.getOriginalFilename());
                f.setContent(member.getBytes());
                
                fileids.add(id);
                fileService.insertFile(f);
            }
        }
        return fileids;
    }

}
