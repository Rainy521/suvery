package com.lwch.survey.dao.mapper;

import java.util.List;

import com.lwch.survey.model.Descrip;
import com.lwch.survey.model.DescripExample;

public interface DescripMapper {
    long countByExample(DescripExample example);

    int deleteByExample(DescripExample example);

    int deleteByPrimaryKey(String id);

    int insert(Descrip record);

    int insertSelective(Descrip record);

    List<Descrip> selectByExample(DescripExample example);

    Descrip selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Descrip record);

    int updateByPrimaryKey(Descrip record);
}