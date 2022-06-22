package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.JsgcghxkDossierApply;
import com.lwch.survey.model.JsgcghxkDossierApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsgcghxkDossierApplyMapper {
    long countByExample(JsgcghxkDossierApplyExample example);

    int deleteByExample(JsgcghxkDossierApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsgcghxkDossierApply record);

    int insertSelective(JsgcghxkDossierApply record);

    List<JsgcghxkDossierApply> selectByExample(JsgcghxkDossierApplyExample example);

    JsgcghxkDossierApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsgcghxkDossierApply record, @Param("example") JsgcghxkDossierApplyExample example);

    int updateByExample(@Param("record") JsgcghxkDossierApply record, @Param("example") JsgcghxkDossierApplyExample example);

    int updateByPrimaryKeySelective(JsgcghxkDossierApply record);

    int updateByPrimaryKey(JsgcghxkDossierApply record);
}