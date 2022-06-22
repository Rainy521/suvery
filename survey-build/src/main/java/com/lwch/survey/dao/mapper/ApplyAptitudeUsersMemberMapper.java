package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyAptitudeUsersMember;
import com.lwch.survey.model.ApplyAptitudeUsersMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyAptitudeUsersMemberMapper {
    long countByExample(ApplyAptitudeUsersMemberExample example);

    int deleteByExample(ApplyAptitudeUsersMemberExample example);

    int insert(ApplyAptitudeUsersMember record);

    int insertSelective(ApplyAptitudeUsersMember record);

    List<ApplyAptitudeUsersMember> selectByExample(ApplyAptitudeUsersMemberExample example);

    int updateByExampleSelective(@Param("record") ApplyAptitudeUsersMember record, @Param("example") ApplyAptitudeUsersMemberExample example);

    int updateByExample(@Param("record") ApplyAptitudeUsersMember record, @Param("example") ApplyAptitudeUsersMemberExample example);
}