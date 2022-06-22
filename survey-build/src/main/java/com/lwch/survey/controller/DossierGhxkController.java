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
import com.lwch.survey.model.JsgcghxkDossierApply;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.JsgcghxkDossier;
import com.lwch.survey.pojo.JsgcghxkParam;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.DossierGhxkService;

@RestController
@RequestMapping("/dossierGhxk")
public class DossierGhxkController {

	@Autowired
	private DossierGhxkService dossierGhxkService;
	
	@PostMapping
    public ResponseObject query(@RequestBody DossierParam dossierParam) {
        return dossierGhxkService.query(dossierParam);
    }
	
	@PostMapping("/save")
    public long save(@RequestBody JsgcghxkDossier jsgcghxkDossier) {
		if (null != jsgcghxkDossier.getId() &&
				dossierGhxkService.getOne(jsgcghxkDossier.getId()) != null) {
			return dossierGhxkService.updateDossier(jsgcghxkDossier);
		}
        return dossierGhxkService.saveDossier(jsgcghxkDossier);
    }
	
	@GetMapping("/getOne")
	public JsgcghxkDossier getOne(@RequestParam Integer id) {
        return dossierGhxkService.getOne(id);
    }
	
	@DeleteMapping("/remove/{id}")
    public void removeDossierById(@PathVariable Integer id) {
        
		dossierGhxkService.removeDossierById(id);
    }
	
	@GetMapping("/cehui/applyDowning")
	public ResponseObject applyCehuiDowning(@RequestParam Integer id) {
        return dossierGhxkService.applyCehuiDowning(id);
    }
	
	@PostMapping("/cehui/query")
	public ResponseObject applyCehuiQuery(@RequestBody JsgcghxkParam jsgcghxkParam) {
        return dossierGhxkService.applyCehuiQuery(jsgcghxkParam);
    }
	
	@PostMapping("/cehui/save")
    public long updateCehui(@RequestBody JsgcghxkDossierApply jsgcghxkDossierApply) {
        return dossierGhxkService.updateCehui(jsgcghxkDossierApply);
    }
	
	@GetMapping("/cehui/getOne")
	public JsgcghxkDossier getCehuiOne(@RequestParam Integer id) {
        return dossierGhxkService.getCehuiOne(id);
    }
	
	@GetMapping("/applyDowning")
	public ResponseObject applyDowning(@RequestParam Integer id) {
        return dossierGhxkService.applyDowning(id);
    }
	
	@PostMapping("/examine/query")
    public ResponseObject queryExamine(@RequestBody JsgcghxkParam jsgcghxkParam) {
        return dossierGhxkService.queryExamine(jsgcghxkParam);
    }
	
	@PostMapping("/examine/operation")
    public ResponseObject operationExamine(@RequestBody JsgcghxkParam jsgcghxkParam) {
        return dossierGhxkService.operationExamine(jsgcghxkParam);
    }
	
	@PostMapping("/cehui/new/query")
	public ResponseObject applyCehuiNewQuery(@RequestBody DossierParam dossierParam) {
		dossierParam.setLoginUser(Utils.getCurrentUsername());
        return dossierGhxkService.applyCehuiNewQuery(dossierParam);
    }
	
	@PostMapping("/cehui/new/save")
    public long updateNewCehui(@RequestBody JsgcghxkDossierApply jsgcghxkDossierApply) {
        return dossierGhxkService.saveNewCehui(jsgcghxkDossierApply);
    }
	
	
}
