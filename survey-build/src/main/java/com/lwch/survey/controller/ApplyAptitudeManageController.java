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
import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.service.ApplyAptitudeService;
import com.lwch.survey.service.ProcessCommonService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/manage/applyAptitude")
public class ApplyAptitudeManageController {
    
    @Autowired
    private ApplyAptitudeService applyAptitudeService;
    
    @Autowired
    private ProcessCommonService processCommonService;
    
    @PostMapping
    public void saveApplyAptitude(@RequestBody ApplyAptitude applyAptitude) {
        if (applyAptitudeService.selectPrimaryKey(applyAptitude.getId()) != null) {
            applyAptitudeService.updateApplyAptitude(applyAptitude);
            
            return;
        }
        applyAptitude.setId(processCommonService.generate("APM"));
        applyAptitudeService.insertApplyAptitude(applyAptitude, Utils.getCurrentUsername());
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable String id) {
        applyAptitudeService.deleteApplyAptitude(id);
    }
    
}
