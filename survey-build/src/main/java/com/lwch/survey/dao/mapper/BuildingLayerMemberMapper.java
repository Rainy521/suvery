package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.BuildingLayerMember;
import com.lwch.survey.model.BuildingLayerMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingLayerMemberMapper {
    long countByExample(BuildingLayerMemberExample example);

    int deleteByExample(BuildingLayerMemberExample example);

    int insert(BuildingLayerMember record);

    int insertSelective(BuildingLayerMember record);

    List<BuildingLayerMember> selectByExample(BuildingLayerMemberExample example);

    int updateByExampleSelective(@Param("record") BuildingLayerMember record, @Param("example") BuildingLayerMemberExample example);

    int updateByExample(@Param("record") BuildingLayerMember record, @Param("example") BuildingLayerMemberExample example);
}