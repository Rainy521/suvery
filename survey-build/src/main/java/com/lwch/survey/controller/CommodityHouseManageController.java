/**
 * 
 */
package com.lwch.survey.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lwch.survey.controller.file.MultipartFileToFile;
import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.CommodityHouseService;
import com.lwch.survey.service.ProcessCommonService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/manage/commodityHouse")
public class CommodityHouseManageController {
    
    @Autowired
    private CommodityHouseService commodityHouseService;
    
    @Autowired
    private ProcessCommonService processCommonService;
    
    @PostMapping
    public ResponseObject saveApplyProject(@RequestBody ApplyProject applyProject) {
        
        if (commodityHouseService.selectPrimaryKey(applyProject.getId()) != null) {
        	applyProject.setProjectNo(applyProject.getId());
        	applyProject.getApplyBuild().setSlbh(applyProject.getId());
            return commodityHouseService.updateApplyProject(applyProject,Utils.getCurrentUsername());
            
        }
        String id = processCommonService.generate("FC");
        applyProject.getApplyBuild().setSlbh(id);
        applyProject.setId(id);
        applyProject.setProjectNo(id);
        return commodityHouseService.insertApplyProject(applyProject, Utils.getCurrentUsername());
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable String id) {
        
        commodityHouseService.deleteApplyProject(id);
    }
    
    @PostMapping("/files")
    public Map<String, String> unZipSave(@RequestParam MultipartFile file) throws Exception {
        
        return commodityHouseService.unZipSave(MultipartFileToFile.multipartFileToFile(file),Utils.getCurrentUsername());

        //fileService.insertFile(f);

        //return Collections.singletonMap("id", id);
    }
    
}
