/**
 * 
 */
package com.lwch.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Archive;
import com.lwch.survey.service.ArchivesService;

/**
 * 档案管理操作Controller
 * @author Rain
 *
 */
@RestController
@RequestMapping("/manage/archives")
public class ArchivesManageController {
    
    @Autowired
    private ArchivesService archivesService;
    
    @PostMapping
    public void save(@RequestBody Archive archive) {
        archivesService.insertManage(archive);
    }
    
    @PostMapping("/update")
    public void update(@RequestBody Archive archive) {
        archivesService.updateManage(archive);
    }
    
    /*@GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return fileManageService.getCount(query);
    }
    
    @GetMapping("/selectByAnnexId")
    public FileManage selectByComanyId(@RequestParam(required=false) String id) {
        return fileManageService.selectPrimaryKey(id);
    }
    
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
