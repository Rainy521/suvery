package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingGhxk;
import com.lwch.survey.model.BuildingGhxkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingGhxkMapper {
    long countByExample(BuildingGhxkExample example);

    int deleteByExample(BuildingGhxkExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingGhxk record);

    int insertSelective(BuildingGhxk record);

    List<BuildingGhxk> selectByExample(BuildingGhxkExample example);

    BuildingGhxk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingGhxk record, @Param("example") BuildingGhxkExample example);

    int updateByExample(@Param("record") BuildingGhxk record, @Param("example") BuildingGhxkExample example);

    int updateByPrimaryKeySelective(BuildingGhxk record);

    int updateByPrimaryKey(BuildingGhxk record);
}