package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyEngineering;
import com.lwch.survey.model.ApplyEngineeringExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyEngineeringMapper {
    long countByExample(ApplyEngineeringExample example);

    int deleteByExample(ApplyEngineeringExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplyEngineering record);

    int insertSelective(ApplyEngineering record);

    List<ApplyEngineering> selectByExample(ApplyEngineeringExample example);

    ApplyEngineering selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplyEngineering record, @Param("example") ApplyEngineeringExample example);

    int updateByExample(@Param("record") ApplyEngineering record, @Param("example") ApplyEngineeringExample example);

    int updateByPrimaryKeySelective(ApplyEngineering record);

    int updateByPrimaryKey(ApplyEngineering record);
}