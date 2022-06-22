package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.ApplyCadastre;
import com.lwch.survey.model.DjchGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;

public interface CadastreService {
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
    static final String COMMDODITY_FORMKEY = "cadastre/applyinfo.html";

	List<ApplyCadastre> query(String query, String currentUsername,PageParm pageParm);

	long getCount(String query, String currentUsername);

	ApplyCadastre getOne(String id);

	ResponseObject updateCadastre(ApplyCadastre applyCadastre);

	ResponseObject insertCadastre(ApplyCadastre applyCadastre, String currentUsername);

	long deleteCadastreById(String id);

	List<DjchGdb> queryGd(DossierParam dossierParam);

	long queryGdCount(DossierParam dossierParam);

	long saveCadastreDossierByApplyId(String applyId);

	DjchGdb getGdbOne(Integer id);

	long updateCadastreDossier(DjchGdb djchGdb);

	long removeDossierById(Integer id);

}
