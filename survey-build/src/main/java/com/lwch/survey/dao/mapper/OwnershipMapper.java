package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.Ownership;
import com.lwch.survey.model.OwnershipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OwnershipMapper {
    long countByExample(OwnershipExample example);

    int deleteByExample(OwnershipExample example);

    int deleteByPrimaryKey(String id);

    int insert(Ownership record);

    int insertSelective(Ownership record);

    List<Ownership> selectByExample(OwnershipExample example);

    Ownership selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ownership record, @Param("example") OwnershipExample example);

    int updateByExample(@Param("record") Ownership record, @Param("example") OwnershipExample example);

    int updateByPrimaryKeySelective(Ownership record);

    int updateByPrimaryKey(Ownership record);

    void batchInsert(@Param("items") List<Ownership> items);
}