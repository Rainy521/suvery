package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.ApplyProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyProjectMapper {
    long countByExample(ApplyProjectExample example);

    int deleteByExample(ApplyProjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplyProject record);

    int insertSelective(ApplyProject record);

    List<ApplyProject> selectByExample(ApplyProjectExample example);

    ApplyProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplyProject record, @Param("example") ApplyProjectExample example);

    int updateByExample(@Param("record") ApplyProject record, @Param("example") ApplyProjectExample example);

    int updateByPrimaryKeySelective(ApplyProject record);

    int updateByPrimaryKey(ApplyProject record);
}