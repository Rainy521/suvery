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

import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.service.DossierService;

@RestController
@RequestMapping("/manage/dossier")
public class DossierManageController {

	@Autowired
	private DossierService dossierService;
	
	@GetMapping("/save")
    public void saveDossier(@RequestParam(required = true ) String applyId) {
        
		dossierService.saveDossierByApplyId(applyId);
    }
	
	@PostMapping("/update")
	public void updateDossier(@RequestBody FcchGdb fcchGdb) {
        
		dossierService.updateDossier(fcchGdb);
    }
	
	@DeleteMapping("/remove/{id}")
    public void removeDossierById(@PathVariable Integer id) {
        
		dossierService.removeDossierById(id);
    }
}
