/**
 * 
 */
package com.lwch.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.service.HouseService;
import com.lwch.survey.service.ProcessCommonService;

@RestController
@RequestMapping("/manage/house")
public class HouseManageController {
    
    @Autowired
    private HouseService houseService;
    
    @Autowired
    private ProcessCommonService processCommonService;

    @PostMapping
    public void insertHouses(@RequestBody Ownership ownership){
        
        if (null != houseService.selectPrimaryKey(ownership.getId())) {
            houseService.updateHouses(ownership);
            
            return;
        }
        
        ownership.setId(processCommonService.generate("H"));
        houseService.insertHouses(ownership , Utils.getCurrentUsername());
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable String id) {
        
        houseService.deleteHouses(id);
    }
    
    @PostMapping("/insertFileMenber")
    public void insertFileMenber(@RequestBody FileTypeApplyMember fileTypeApplyMember){
        
        houseService.insertFileMenber(fileTypeApplyMember);
    }
}
