package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.CustomizationGroupMembers;
import com.lwch.survey.model.CustomizationGroupMembersExample;

public interface CustomizationGroupMembersMapper {
    long countByExample(CustomizationGroupMembersExample example);

    int deleteByExample(CustomizationGroupMembersExample example);

    int insert(CustomizationGroupMembers record);

    int insertSelective(CustomizationGroupMembers record);

    List<CustomizationGroupMembers> selectByExample(CustomizationGroupMembersExample example);

    int updateByExampleSelective(@Param("record") CustomizationGroupMembers record, @Param("example") CustomizationGroupMembersExample example);

    int updateByExample(@Param("record") CustomizationGroupMembers record, @Param("example") CustomizationGroupMembersExample example);
}