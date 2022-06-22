package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.GroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleMapper {
    long countByExample(GroupRoleExample example);

    int deleteByExample(GroupRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupRole record);

    int insertSelective(GroupRole record);

    List<GroupRole> selectByExample(GroupRoleExample example);

    GroupRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByExample(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByPrimaryKeySelective(GroupRole record);

    int updateByPrimaryKey(GroupRole record);
}