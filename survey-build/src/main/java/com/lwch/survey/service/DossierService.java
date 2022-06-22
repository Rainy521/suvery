package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;

public interface DossierService {
	
	/**
     * SIFF文件压缩状态
     */
    static final int PROCESS_INIT_STATUS = 0;

	long saveDossierByApplyId(String applyId);

	List<FcchGdb> query(DossierParam dossierParam);

	long count(DossierParam dossierParam);

	FcchGdb getOne(Integer id);

	long updateDossier(FcchGdb fcchGdb);

	long removeDossierById(Integer id);

	ResponseObject getOldQuery(DossierParam dossierParam);
	
	FcchGdb getOldOne(String hisId);

	FcchGdb getOldOneSiff(String hisId);

	ResponseObject applyFinishQquery(String query, PageParm pageParm);
}
