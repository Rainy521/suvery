package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingJgys;
import com.lwch.survey.model.BuildingJgysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingJgysMapper {
    long countByExample(BuildingJgysExample example);

    int deleteByExample(BuildingJgysExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingJgys record);

    int insertSelective(BuildingJgys record);

    List<BuildingJgys> selectByExample(BuildingJgysExample example);

    BuildingJgys selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingJgys record, @Param("example") BuildingJgysExample example);

    int updateByExample(@Param("record") BuildingJgys record, @Param("example") BuildingJgysExample example);

    int updateByPrimaryKeySelective(BuildingJgys record);

    int updateByPrimaryKey(BuildingJgys record);
}