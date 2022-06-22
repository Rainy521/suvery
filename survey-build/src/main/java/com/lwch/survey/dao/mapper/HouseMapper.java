package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.House;
import com.lwch.survey.model.HouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    long countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    void batchInsert(@Param("items") List<House> items);
}