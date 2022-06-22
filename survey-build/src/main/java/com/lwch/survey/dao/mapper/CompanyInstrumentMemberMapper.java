package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.CompanyInstrumentMember;
import com.lwch.survey.model.CompanyInstrumentMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInstrumentMemberMapper {
    long countByExample(CompanyInstrumentMemberExample example);

    int deleteByExample(CompanyInstrumentMemberExample example);

    int deleteByPrimaryKey(String instrumentId);

    int insert(CompanyInstrumentMember record);

    int insertSelective(CompanyInstrumentMember record);

    List<CompanyInstrumentMember> selectByExample(CompanyInstrumentMemberExample example);

    CompanyInstrumentMember selectByPrimaryKey(String instrumentId);

    int updateByExampleSelective(@Param("record") CompanyInstrumentMember record, @Param("example") CompanyInstrumentMemberExample example);

    int updateByExample(@Param("record") CompanyInstrumentMember record, @Param("example") CompanyInstrumentMemberExample example);

    int updateByPrimaryKeySelective(CompanyInstrumentMember record);

    int updateByPrimaryKey(CompanyInstrumentMember record);
}