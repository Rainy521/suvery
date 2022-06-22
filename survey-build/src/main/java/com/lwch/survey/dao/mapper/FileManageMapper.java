package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;

public interface FileManageMapper {
    long countByExample(FileManageExample example);

    int deleteByExample(FileManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileManage record);

    int insertSelective(FileManage record);

    List<FileManage> selectByExample(FileManageExample example);

    FileManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileManage record, @Param("example") FileManageExample example);

    int updateByExample(@Param("record") FileManage record, @Param("example") FileManageExample example);

    int updateByPrimaryKeySelective(FileManage record);

    int updateByPrimaryKey(FileManage record);
}