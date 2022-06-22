package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyBuilding;
import com.lwch.survey.model.ApplyBuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyBuildingMapper {
    long countByExample(ApplyBuildingExample example);

    int deleteByExample(ApplyBuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplyBuilding record);

    int insertSelective(ApplyBuilding record);

    List<ApplyBuilding> selectByExample(ApplyBuildingExample example);

    ApplyBuilding selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplyBuilding record, @Param("example") ApplyBuildingExample example);

    int updateByExample(@Param("record") ApplyBuilding record, @Param("example") ApplyBuildingExample example);

    int updateByPrimaryKeySelective(ApplyBuilding record);

    int updateByPrimaryKey(ApplyBuilding record);

    void batchInsert(@Param("items") List<ApplyBuilding> items);
}