package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyAptitudeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyAptitudeMapper {
    long countByExample(ApplyAptitudeExample example);

    int deleteByExample(ApplyAptitudeExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplyAptitude record);

    int insertSelective(ApplyAptitude record);

    List<ApplyAptitude> selectByExample(ApplyAptitudeExample example);

    ApplyAptitude selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplyAptitude record, @Param("example") ApplyAptitudeExample example);

    int updateByExample(@Param("record") ApplyAptitude record, @Param("example") ApplyAptitudeExample example);

    int updateByPrimaryKeySelective(ApplyAptitude record);

    int updateByPrimaryKey(ApplyAptitude record);

    void batchInsert(@Param("items") List<ApplyAptitude> items);
}