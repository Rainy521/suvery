package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessStatusMapper {
    long countByExample(ProcessStatusExample example);

    int deleteByExample(ProcessStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProcessStatus record);

    int insertSelective(ProcessStatus record);

    List<ProcessStatus> selectByExample(ProcessStatusExample example);

    ProcessStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProcessStatus record, @Param("example") ProcessStatusExample example);

    int updateByExample(@Param("record") ProcessStatus record, @Param("example") ProcessStatusExample example);

    int updateByPrimaryKeySelective(ProcessStatus record);

    int updateByPrimaryKey(ProcessStatus record);
}