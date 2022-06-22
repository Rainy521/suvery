package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingDomainMember;
import com.lwch.survey.model.BuildingDomainMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingDomainMemberMapper {
    long countByExample(BuildingDomainMemberExample example);

    int deleteByExample(BuildingDomainMemberExample example);

    int insert(BuildingDomainMember record);

    int insertSelective(BuildingDomainMember record);

    List<BuildingDomainMember> selectByExample(BuildingDomainMemberExample example);

    int updateByExampleSelective(@Param("record") BuildingDomainMember record, @Param("example") BuildingDomainMemberExample example);

    int updateByExample(@Param("record") BuildingDomainMember record, @Param("example") BuildingDomainMemberExample example);
}