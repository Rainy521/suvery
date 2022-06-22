package com.lwch.survey.controller.file;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.File;
import com.lwch.survey.service.FileService;
import com.lwch.survey.utils.DownloadUtils;

@RestController
@RequestMapping("/open/files")
public class OpenFileController {

    @Autowired
    private FileService fileService;
    
    @GetMapping("/{id}")
    public void get(@PathVariable String id, final HttpServletResponse response) throws IOException {
        try {
            File file = fileService.selectByPrimaryKey(id);
            
            if(null == file) {
                return;
            }
            
            DownloadUtils.download(file.getName(), file.getContent(), response);
        } catch (ScriptException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
