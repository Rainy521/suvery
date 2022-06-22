package com.lwch.survey.dao.mapper;

import java.util.List;

import com.lwch.survey.model.GroupMember;
import com.lwch.survey.model.GroupMemberExample;

public interface GroupMemberMapper {
    int countByExample(GroupMemberExample example);

    int deleteByExample(GroupMemberExample example);

    int insert(GroupMember record);

    int insertSelective(GroupMember record);

    List<GroupMember> selectByExample(GroupMemberExample example);
}