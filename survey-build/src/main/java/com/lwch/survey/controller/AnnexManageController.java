package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.FileManage;
import com.lwch.survey.service.FileManageService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/manage/annex")
public class AnnexManageController {
    
    @Autowired
    private FileManageService fileManageService;
    
    @PostMapping
    public void saveFileManage(@RequestBody FileManage fileManage) {
        
        if (null != fileManageService.selectPrimaryKey(fileManage.getId())) {
            fileManageService.updateFileManage(fileManage);
            return;
        }
        fileManageService.insertFileManage(fileManage);
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable Integer id) {
        
        fileManageService.deleteFileManage(id);
    }
    
    @PostMapping("/{id}/business/add")
    public void addBus(@PathVariable Integer id,@RequestBody List<String> bus) {
        fileManageService.insertBusiness(id, bus);
    }
    
    @PostMapping("/{businessId}/fileManage/add")
    public void addfileManages(@PathVariable String businessId,@RequestBody List<Integer> ids) {
        fileManageService.inserFileManages(businessId, ids);
    }
    
    @DeleteMapping("/{id}/{name}/business/remove")
    public void deleteBusiness(@PathVariable Integer id,@PathVariable String name) {
        
        fileManageService.deleteBusiness(id,name);
    }
    
}
