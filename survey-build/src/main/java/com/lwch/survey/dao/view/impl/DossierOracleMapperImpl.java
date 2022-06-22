package com.lwch.survey.dao.view.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lwch.survey.dao.view.DossierOracleMapper;
import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.pojo.DossierParam;

@Repository("dossierOracleDao")
public class DossierOracleMapperImpl implements DossierOracleMapper {
	
	@Autowired
	private SqlSessionTemplate viewSqlSessionTemplate;

	@Override
	public List<FcchGdb> getDatas(DossierParam dossierParam) {
		return viewSqlSessionTemplate.selectList("HistoryFcchGdbMapper.getData", dossierParam);
	}

	@Override
	public Long getDatasCount(DossierParam dossierParam) {
		return viewSqlSessionTemplate.selectOne("HistoryFcchGdbMapper.getDatasCount", dossierParam);
	}

	@Override
	public FcchGdb getDataByOldId(String hisId) {
		return viewSqlSessionTemplate.selectOne("HistoryFcchGdbMapper.getDataByOldId", hisId);
	}

	@Override
	public FcchGdb getDataBySiff(String hisId) {
		return viewSqlSessionTemplate.selectOne("HistoryFcchGdbMapper.getDataBySiff", hisId);
	}


	@Override
	public int test() 
	{
		return 0;
	}

	

}
