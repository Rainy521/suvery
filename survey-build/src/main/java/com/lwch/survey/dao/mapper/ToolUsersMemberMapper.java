package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToolUsersMemberMapper {
    long countByExample(ToolUsersMemberExample example);

    int deleteByExample(ToolUsersMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(ToolUsersMember record);

    int insertSelective(ToolUsersMember record);

    List<ToolUsersMember> selectByExample(ToolUsersMemberExample example);

    ToolUsersMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ToolUsersMember record, @Param("example") ToolUsersMemberExample example);

    int updateByExample(@Param("record") ToolUsersMember record, @Param("example") ToolUsersMemberExample example);

    int updateByPrimaryKeySelective(ToolUsersMember record);

    int updateByPrimaryKey(ToolUsersMember record);
}