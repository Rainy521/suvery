package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.ApplyEngineering;
import com.lwch.survey.model.GcclGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;

public interface EngineeringService {

	/**
	 * 归档有效性,0,有效
	 */
	static final Integer GD_YXX_YES = 0;
	
	/**
	 * 归档有效性,1,无效
	 */
	static final Integer GD_YXX_NO = 1;
	
	/**
     * 初始流程状态设置
     */
    static final String PROCESS_INIT_STATUS = "0";
    
    /**
     * 结束流程状态默认
     */
    static final String PROCESS_END_STATUS = "3";
    
    /**
     * 已办理查看的formkey设置
     */
    static final String COMMDODITY_FORMKEY = "engineering/applyinfo.html";

	List<ApplyEngineering> query(String query, String currentUsername,PageParm pageParm);

	long getCount(String query, String currentUsername);

	ApplyEngineering getOne(String id);

	ResponseObject updateEngineering(ApplyEngineering applyEngineering);

	ResponseObject insertEngineering(ApplyEngineering applyEngineering, String currentUsername);

	long deleteEngineeringById(String id);

	List<GcclGdb> queryGd(DossierParam dossierParam);

	long queryGdCount(DossierParam dossierParam);

	long saveEngineeringDossierByApplyId(String applyId);

	GcclGdb getGdbOne(Integer id);

	long updateEngineeringDossier(GcclGdb GcclGdb);

	long removeDossierById(Integer id);
}
