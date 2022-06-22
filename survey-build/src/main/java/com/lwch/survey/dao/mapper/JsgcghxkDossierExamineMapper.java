package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.JsgcghxkDossierExamine;
import com.lwch.survey.model.JsgcghxkDossierExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsgcghxkDossierExamineMapper {
    long countByExample(JsgcghxkDossierExamineExample example);

    int deleteByExample(JsgcghxkDossierExamineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsgcghxkDossierExamine record);

    int insertSelective(JsgcghxkDossierExamine record);

    List<JsgcghxkDossierExamine> selectByExample(JsgcghxkDossierExamineExample example);

    JsgcghxkDossierExamine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsgcghxkDossierExamine record, @Param("example") JsgcghxkDossierExamineExample example);

    int updateByExample(@Param("record") JsgcghxkDossierExamine record, @Param("example") JsgcghxkDossierExamineExample example);

    int updateByPrimaryKeySelective(JsgcghxkDossierExamine record);

    int updateByPrimaryKey(JsgcghxkDossierExamine record);
}