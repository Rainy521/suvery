package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;

public interface FileTypeApplyMemberMapper {
    long countByExample(FileTypeApplyMemberExample example);

    int deleteByExample(FileTypeApplyMemberExample example);

    int insert(FileTypeApplyMember record);

    int insertSelective(FileTypeApplyMember record);

    List<FileTypeApplyMember> selectByExample(FileTypeApplyMemberExample example);

    int updateByExampleSelective(@Param("record") FileTypeApplyMember record, @Param("example") FileTypeApplyMemberExample example);

    int updateByExample(@Param("record") FileTypeApplyMember record, @Param("example") FileTypeApplyMemberExample example);
}