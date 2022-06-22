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
import com.lwch.survey.model.ApplyCadastre;
import com.lwch.survey.model.DjchGdb;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.CadastreService;
import com.lwch.survey.service.ProcessCommonService;

@RestController
@RequestMapping("/manage/cadastre")
public class CadastreManageController {
	
	@Autowired
	private CadastreService cadastreService;

	@Autowired
    private ProcessCommonService processCommonService;
	
	@PostMapping
    public ResponseObject saveApplyCadastre(@RequestBody ApplyCadastre applyCadastre) {
        if (null != cadastreService.getOne(applyCadastre.getId())) {
        	return cadastreService.updateCadastre(applyCadastre);
        }
        
        applyCadastre.setId(processCommonService.generate("DJ"));
        return cadastreService.insertCadastre(applyCadastre, Utils.getCurrentUsername());
    }
    
    @DeleteMapping("/remove/{id}")
    public void deleteCase(@PathVariable String id) {
    	cadastreService.deleteCadastreById(id);
    }
    
    @GetMapping("/gdb/save")
    public void saveCadastreDossier(@RequestParam(required = true ) String applyId) {
        
    	cadastreService.saveCadastreDossierByApplyId(applyId);
    }
    
    @PostMapping("/gdb/update")
    public void updateCadastreDossier(@RequestBody DjchGdb djchGdb) {
        
    	cadastreService.updateCadastreDossier(djchGdb);
    }
    
    @DeleteMapping("/gdb/remove/{id}")
    public void removeDossierById(@PathVariable Integer id) {
        
    	cadastreService.removeDossierById(id);
    }
}
