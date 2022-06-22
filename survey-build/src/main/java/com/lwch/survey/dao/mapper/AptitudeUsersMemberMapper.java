package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.AptitudeUsersMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AptitudeUsersMemberMapper {
    long countByExample(AptitudeUsersMemberExample example);

    int deleteByExample(AptitudeUsersMemberExample example);

    int deleteByPrimaryKey(String username);

    int insert(AptitudeUsersMember record);

    int insertSelective(AptitudeUsersMember record);

    List<AptitudeUsersMember> selectByExample(AptitudeUsersMemberExample example);

    AptitudeUsersMember selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") AptitudeUsersMember record, @Param("example") AptitudeUsersMemberExample example);

    int updateByExample(@Param("record") AptitudeUsersMember record, @Param("example") AptitudeUsersMemberExample example);

    int updateByPrimaryKeySelective(AptitudeUsersMember record);

    int updateByPrimaryKey(AptitudeUsersMember record);
}