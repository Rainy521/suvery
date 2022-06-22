package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.Archive;
import com.lwch.survey.model.ArchiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveMapper {
    long countByExample(ArchiveExample example);

    int deleteByExample(ArchiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Archive record);

    int insertSelective(Archive record);

    List<Archive> selectByExample(ArchiveExample example);

    Archive selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Archive record, @Param("example") ArchiveExample example);

    int updateByExample(@Param("record") Archive record, @Param("example") ArchiveExample example);

    int updateByPrimaryKeySelective(Archive record);

    int updateByPrimaryKey(Archive record);
}