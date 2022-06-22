package com.lwch.survey.dao.mapper;

import java.util.List;

import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.JsgcghxkDossier;

public interface IDossierGhxkDao {

	List<JsgcghxkDossier> query(DossierParam dossierParam);
	
	JsgcghxkDossier queryOne(Integer id);
	
	long queryCount(DossierParam dossierParam);

	long saveDossier(JsgcghxkDossier jsgcghxkDossier);

	long updateDossier(JsgcghxkDossier jsgcghxkDossier);

	long removeDossierById(Integer id);
	
	List<JsgcghxkDossier> queryNewList(DossierParam dossierParam) ;

	Long queryNewListCount(DossierParam dossierParam);
}
