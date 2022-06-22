package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingJggh;
import com.lwch.survey.model.BuildingJgghExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingJgghMapper {
    long countByExample(BuildingJgghExample example);

    int deleteByExample(BuildingJgghExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingJggh record);

    int insertSelective(BuildingJggh record);

    List<BuildingJggh> selectByExample(BuildingJgghExample example);

    BuildingJggh selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingJggh record, @Param("example") BuildingJgghExample example);

    int updateByExample(@Param("record") BuildingJggh record, @Param("example") BuildingJgghExample example);

    int updateByPrimaryKeySelective(BuildingJggh record);

    int updateByPrimaryKey(BuildingJggh record);
}