package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyCadastre;
import com.lwch.survey.model.ApplyCadastreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyCadastreMapper {
    long countByExample(ApplyCadastreExample example);

    int deleteByExample(ApplyCadastreExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplyCadastre record);

    int insertSelective(ApplyCadastre record);

    List<ApplyCadastre> selectByExample(ApplyCadastreExample example);

    ApplyCadastre selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplyCadastre record, @Param("example") ApplyCadastreExample example);

    int updateByExample(@Param("record") ApplyCadastre record, @Param("example") ApplyCadastreExample example);

    int updateByPrimaryKeySelective(ApplyCadastre record);

    int updateByPrimaryKey(ApplyCadastre record);
}