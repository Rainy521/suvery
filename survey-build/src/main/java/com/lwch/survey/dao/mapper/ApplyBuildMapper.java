package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyBuild;
import com.lwch.survey.model.ApplyBuildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyBuildMapper {
    long countByExample(ApplyBuildExample example);

    int deleteByExample(ApplyBuildExample example);

    int deleteByPrimaryKey(String slbh);

    int insert(ApplyBuild record);

    int insertSelective(ApplyBuild record);

    List<ApplyBuild> selectByExample(ApplyBuildExample example);

    ApplyBuild selectByPrimaryKey(String slbh);

    int updateByExampleSelective(@Param("record") ApplyBuild record, @Param("example") ApplyBuildExample example);

    int updateByExample(@Param("record") ApplyBuild record, @Param("example") ApplyBuildExample example);

    int updateByPrimaryKeySelective(ApplyBuild record);

    int updateByPrimaryKey(ApplyBuild record);
}