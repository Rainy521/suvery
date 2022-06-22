package com.lwch.survey.dao.view;

import java.util.List;

import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.pojo.DossierParam;

public interface DossierOracleMapper {
	
	List<FcchGdb> getDatas(DossierParam dossierParam);
	
	int test();

	FcchGdb getDataBySiff(String hisId);

	Long getDatasCount(DossierParam dossierParam);

	FcchGdb getDataByOldId(String hisId);
}