package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.CompanyHistory;
import com.lwch.survey.model.CompanyHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyHistoryMapper {
    long countByExample(CompanyHistoryExample example);

    int deleteByExample(CompanyHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyHistory record);

    int insertSelective(CompanyHistory record);

    List<CompanyHistory> selectByExample(CompanyHistoryExample example);

    CompanyHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyHistory record, @Param("example") CompanyHistoryExample example);

    int updateByExample(@Param("record") CompanyHistory record, @Param("example") CompanyHistoryExample example);

    int updateByPrimaryKeySelective(CompanyHistory record);

    int updateByPrimaryKey(CompanyHistory record);
}