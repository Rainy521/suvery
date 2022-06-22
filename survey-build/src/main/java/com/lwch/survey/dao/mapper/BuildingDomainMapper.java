package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingDomain;
import com.lwch.survey.model.BuildingDomainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingDomainMapper {
    long countByExample(BuildingDomainExample example);

    int deleteByExample(BuildingDomainExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuildingDomain record);

    int insertSelective(BuildingDomain record);

    List<BuildingDomain> selectByExample(BuildingDomainExample example);

    BuildingDomain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuildingDomain record, @Param("example") BuildingDomainExample example);

    int updateByExample(@Param("record") BuildingDomain record, @Param("example") BuildingDomainExample example);

    int updateByPrimaryKeySelective(BuildingDomain record);

    int updateByPrimaryKey(BuildingDomain record);

    void batchInsert(@Param("items") List<BuildingDomain> items);
}