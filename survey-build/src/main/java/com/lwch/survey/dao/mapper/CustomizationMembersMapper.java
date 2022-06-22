package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.CustomizationMembers;
import com.lwch.survey.model.CustomizationMembersExample;

public interface CustomizationMembersMapper {
    long countByExample(CustomizationMembersExample example);

    int deleteByExample(CustomizationMembersExample example);

    int insert(CustomizationMembers record);

    int insertSelective(CustomizationMembers record);

    List<CustomizationMembers> selectByExample(CustomizationMembersExample example);

    int updateByExampleSelective(@Param("record") CustomizationMembers record, @Param("example") CustomizationMembersExample example);

    int updateByExample(@Param("record") CustomizationMembers record, @Param("example") CustomizationMembersExample example);
}