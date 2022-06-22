package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.MenuUsergroupMember;
import com.lwch.survey.model.MenuUsergroupMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuUsergroupMemberMapper {
    long countByExample(MenuUsergroupMemberExample example);

    int deleteByExample(MenuUsergroupMemberExample example);

    int insert(MenuUsergroupMember record);

    int insertSelective(MenuUsergroupMember record);

    List<MenuUsergroupMember> selectByExample(MenuUsergroupMemberExample example);

    int updateByExampleSelective(@Param("record") MenuUsergroupMember record, @Param("example") MenuUsergroupMemberExample example);

    int updateByExample(@Param("record") MenuUsergroupMember record, @Param("example") MenuUsergroupMemberExample example);
}