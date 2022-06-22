package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.GcclGdb;
import com.lwch.survey.model.GcclGdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GcclGdbMapper {
    long countByExample(GcclGdbExample example);

    int deleteByExample(GcclGdbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GcclGdb record);

    int insertSelective(GcclGdb record);

    List<GcclGdb> selectByExample(GcclGdbExample example);

    GcclGdb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GcclGdb record, @Param("example") GcclGdbExample example);

    int updateByExample(@Param("record") GcclGdb record, @Param("example") GcclGdbExample example);

    int updateByPrimaryKeySelective(GcclGdb record);

    int updateByPrimaryKey(GcclGdb record);
}