package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyEmployee;
import com.lwch.survey.model.ApplyEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyEmployeeMapper {
    long countByExample(ApplyEmployeeExample example);

    int deleteByExample(ApplyEmployeeExample example);

    int deleteByPrimaryKey(String idCard);

    int insert(ApplyEmployee record);

    int insertSelective(ApplyEmployee record);

    List<ApplyEmployee> selectByExample(ApplyEmployeeExample example);

    ApplyEmployee selectByPrimaryKey(String idCard);

    int updateByExampleSelective(@Param("record") ApplyEmployee record, @Param("example") ApplyEmployeeExample example);

    int updateByExample(@Param("record") ApplyEmployee record, @Param("example") ApplyEmployeeExample example);

    int updateByPrimaryKeySelective(ApplyEmployee record);

    int updateByPrimaryKey(ApplyEmployee record);

    void batchInsert(@Param("items") List<ApplyEmployee> items);
}