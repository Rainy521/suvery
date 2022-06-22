package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.FileManageMember;
import com.lwch.survey.model.FileManageMemberExample;

public interface FileManageMemberMapper {
    long countByExample(FileManageMemberExample example);

    int deleteByExample(FileManageMemberExample example);

    int insert(FileManageMember record);

    int insertSelective(FileManageMember record);

    List<FileManageMember> selectByExample(FileManageMemberExample example);

    int updateByExampleSelective(@Param("record") FileManageMember record, @Param("example") FileManageMemberExample example);

    int updateByExample(@Param("record") FileManageMember record, @Param("example") FileManageMemberExample example);
}