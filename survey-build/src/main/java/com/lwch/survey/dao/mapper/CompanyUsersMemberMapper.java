package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.CompanyUsersMember;
import com.lwch.survey.model.CompanyUsersMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyUsersMemberMapper {
    long countByExample(CompanyUsersMemberExample example);

    int deleteByExample(CompanyUsersMemberExample example);

    int deleteByPrimaryKey(String username);

    int insert(CompanyUsersMember record);

    int insertSelective(CompanyUsersMember record);

    List<CompanyUsersMember> selectByExample(CompanyUsersMemberExample example);

    CompanyUsersMember selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") CompanyUsersMember record, @Param("example") CompanyUsersMemberExample example);

    int updateByExample(@Param("record") CompanyUsersMember record, @Param("example") CompanyUsersMemberExample example);

    int updateByPrimaryKeySelective(CompanyUsersMember record);

    int updateByPrimaryKey(CompanyUsersMember record);
}