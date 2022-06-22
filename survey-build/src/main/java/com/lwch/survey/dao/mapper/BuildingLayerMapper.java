package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingLayer;
import com.lwch.survey.model.BuildingLayerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingLayerMapper {
    long countByExample(BuildingLayerExample example);

    int deleteByExample(BuildingLayerExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingLayer record);

    int insertSelective(BuildingLayer record);

    List<BuildingLayer> selectByExample(BuildingLayerExample example);

    BuildingLayer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingLayer record, @Param("example") BuildingLayerExample example);

    int updateByExample(@Param("record") BuildingLayer record, @Param("example") BuildingLayerExample example);

    int updateByPrimaryKeySelective(BuildingLayer record);

    int updateByPrimaryKey(BuildingLayer record);

    void batchInsert(@Param("items") List<BuildingLayer> items);
}