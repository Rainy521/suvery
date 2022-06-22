package com.lwch.survey.dao.mapper.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lwch.survey.dao.mapper.IDossierGhxkDao;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.JsgcghxkDossier;

@Repository("dossierGhxkDao")
public class DossierGhxkDaoImpl implements IDossierGhxkDao {

	@Autowired
    private SqlSessionTemplate localSqlSessionTemplate;
	
	@Override
	public List<JsgcghxkDossier> query(DossierParam dossierParam) {
		
		return localSqlSessionTemplate.selectList("DossierGhxkMapper.queryList", dossierParam);
	}
	
	@Override
	public List<JsgcghxkDossier> queryNewList(DossierParam dossierParam) {
		
		return localSqlSessionTemplate.selectList("DossierGhxkMapper.queryNewList", dossierParam);
	}

	@Override
	public Long queryNewListCount(DossierParam dossierParam) {
		return localSqlSessionTemplate.selectOne("DossierGhxkMapper.queryNewListCount", dossierParam);
	}

	@Override
	public long queryCount(DossierParam dossierParam) {
		return localSqlSessionTemplate.selectOne("DossierGhxkMapper.queryCount", dossierParam);
	}

	@Override
	public long removeDossierById(Integer id) {
		return localSqlSessionTemplate.delete("DossierGhxkMapper.removeDossierById", id);
	}

	@Override
	public JsgcghxkDossier queryOne(Integer id) {
		return localSqlSessionTemplate.selectOne("DossierGhxkMapper.queryOne", id);
	}

	@Override
	public long saveDossier(JsgcghxkDossier jsgcghxkDossier) {
		return localSqlSessionTemplate.insert("DossierGhxkMapper.saveDossier", jsgcghxkDossier);
	}

	@Override
	public long updateDossier(JsgcghxkDossier jsgcghxkDossier) {
		return localSqlSessionTemplate.update("DossierGhxkMapper.updateDossier", jsgcghxkDossier);
	}

}
