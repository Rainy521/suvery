package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.model.InstrumenttationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstrumenttationMapper {
    long countByExample(InstrumenttationExample example);

    int deleteByExample(InstrumenttationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Instrumenttation record);

    int insertSelective(Instrumenttation record);

    List<Instrumenttation> selectByExample(InstrumenttationExample example);

    Instrumenttation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Instrumenttation record, @Param("example") InstrumenttationExample example);

    int updateByExample(@Param("record") Instrumenttation record, @Param("example") InstrumenttationExample example);

    int updateByPrimaryKeySelective(Instrumenttation record);

    int updateByPrimaryKey(Instrumenttation record);

    void batchInsert(@Param("items") List<Instrumenttation> items);
}