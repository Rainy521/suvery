package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingShare;
import com.lwch.survey.model.BuildingShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingShareMapper {
    long countByExample(BuildingShareExample example);

    int deleteByExample(BuildingShareExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingShare record);

    int insertSelective(BuildingShare record);

    List<BuildingShare> selectByExample(BuildingShareExample example);

    BuildingShare selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingShare record, @Param("example") BuildingShareExample example);

    int updateByExample(@Param("record") BuildingShare record, @Param("example") BuildingShareExample example);

    int updateByPrimaryKeySelective(BuildingShare record);

    int updateByPrimaryKey(BuildingShare record);
}