package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.DjchGdb;
import com.lwch.survey.model.DjchGdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjchGdbMapper {
    long countByExample(DjchGdbExample example);

    int deleteByExample(DjchGdbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DjchGdb record);

    int insertSelective(DjchGdb record);

    List<DjchGdb> selectByExample(DjchGdbExample example);

    DjchGdb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DjchGdb record, @Param("example") DjchGdbExample example);

    int updateByExample(@Param("record") DjchGdb record, @Param("example") DjchGdbExample example);

    int updateByPrimaryKeySelective(DjchGdb record);

    int updateByPrimaryKey(DjchGdb record);
}