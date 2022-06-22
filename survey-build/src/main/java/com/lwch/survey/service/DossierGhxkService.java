package com.lwch.survey.service;

import com.lwch.survey.model.JsgcghxkDossierApply;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.JsgcghxkDossier;
import com.lwch.survey.pojo.JsgcghxkParam;
import com.lwch.survey.pojo.ResponseObject;

public interface DossierGhxkService {
	

	ResponseObject query(DossierParam dossierParam);

	long saveDossier(JsgcghxkDossier jsgcghxkDossier);

	long updateDossier(JsgcghxkDossier jsgcghxkDossier);

	long removeDossierById(Integer id);

	JsgcghxkDossier getOne(Integer id);

	ResponseObject queryExamine(JsgcghxkParam jsgcghxkParam);

	ResponseObject applyDowning(Integer id);

	ResponseObject operationExamine(JsgcghxkParam jsgcghxkParam);

	ResponseObject applyCehuiDowning(Integer id);

	ResponseObject applyCehuiQuery(JsgcghxkParam jsgcghxkParam);

	long updateCehui(JsgcghxkDossierApply jsgcghxkDossierApply);

	JsgcghxkDossier getCehuiOne(Integer id);

	ResponseObject applyCehuiNewQuery(DossierParam dossierParam);

	long saveNewCehui(JsgcghxkDossierApply jsgcghxkDossierApply);

}
