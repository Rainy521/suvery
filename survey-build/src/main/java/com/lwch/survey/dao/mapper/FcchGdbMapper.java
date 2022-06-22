package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.model.FcchGdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FcchGdbMapper {
    long countByExample(FcchGdbExample example);

    int deleteByExample(FcchGdbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FcchGdb record);

    int insertSelective(FcchGdb record);

    List<FcchGdb> selectByExample(FcchGdbExample example);

    FcchGdb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FcchGdb record, @Param("example") FcchGdbExample example);

    int updateByExample(@Param("record") FcchGdb record, @Param("example") FcchGdbExample example);

    int updateByPrimaryKeySelective(FcchGdb record);

    int updateByPrimaryKey(FcchGdb record);
}