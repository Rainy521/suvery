/**
 * 
 */
package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Archive;
import com.lwch.survey.model.ArchiveExample;
import com.lwch.survey.service.ArchivesService;

/**
 * 档案管理Controller
 * @author Rain
 *
 */
@RestController
@RequestMapping("/archives")
public class ArchivesController {
    
    @Autowired
    private ArchivesService archivesService;
    
    @GetMapping
    public List<Archive> getQueryList(@RequestParam(required=false) String query) {
        return archivesService.getArchives(new ArchiveExample() , query);
    }
    
    @GetMapping("/viewShow")
    public List<Archive> getList() {
        return archivesService.getAllArchives(new ArchiveExample());
    }
    
    @GetMapping("/flagArchive")
    public boolean selectById(@RequestParam(required=false) String id) {
        return archivesService.selectId(id);
    }
    
    /*
    
    
    @GetMapping("/configs/fileType")
    public List<Config> selectConfig(){
        String configPrefix ="annexmanage.file.type";
        return configService.selectConfigs(configPrefix);
    }
    
    @GetMapping("/business")
    public List<FileManageMember> selectByfileId(@RequestParam(required=false) String id) {
        return fileManageService.selectByfileId(id);
    }
    
    @GetMapping("/filemanageIds")
    public Map<String, String> getbusIds(){
        return fileManageService.getbusIds();
    }*/
}
