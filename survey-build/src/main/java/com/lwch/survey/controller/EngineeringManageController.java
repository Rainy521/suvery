package com.lwch.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.ApplyEngineering;
import com.lwch.survey.model.GcclGdb;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.EngineeringService;
import com.lwch.survey.service.ProcessCommonService;

@RestController
@RequestMapping("/manage/engineering")
public class EngineeringManageController {

	@Autowired
	private EngineeringService engineeringService;
	
	@Autowired
    private ProcessCommonService processCommonService;
	
	@PostMapping
    public ResponseObject saveApplyEngineering(@RequestBody ApplyEngineering applyEngineering) {
        if (null != engineeringService.getOne(applyEngineering.getId())) {
        	return engineeringService.updateEngineering(applyEngineering);
        }
        
        applyEngineering.setId(processCommonService.generate("GC"));
        return engineeringService.insertEngineering(applyEngineering, Utils.getCurrentUsername());
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable String id) {
    	engineeringService.deleteEngineeringById(id);
    }
    
    @GetMapping("/gdb/save")
    public void saveEngineeringDossier(@RequestParam(required = true ) String applyId) {
        
    	engineeringService.saveEngineeringDossierByApplyId(applyId);
    }
    
    @PostMapping("/gdb/update")
    public void updateEngineeringDossier(@RequestBody GcclGdb gcclGdb) {
        
    	engineeringService.updateEngineeringDossier(gcclGdb);
    }
    
    @DeleteMapping("/gdb/remove/{id}")
    public void removeDossierById(@PathVariable Integer id) {
        
    	engineeringService.removeDossierById(id);
    }
}
