package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.Customization;
import com.lwch.survey.model.CustomizationExample;

public interface CustomizationMapper {
    long countByExample(CustomizationExample example);

    int deleteByExample(CustomizationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Customization record);

    int insertSelective(Customization record);

    List<Customization> selectByExample(CustomizationExample example);

    Customization selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Customization record, @Param("example") CustomizationExample example);

    int updateByExample(@Param("record") Customization record, @Param("example") CustomizationExample example);

    int updateByPrimaryKeySelective(Customization record);

    int updateByPrimaryKey(Customization record);
}