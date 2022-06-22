package com.lwch.survey.dao.mapper;

import com.lwch.survey.model.ApplyInstrument;
import com.lwch.survey.model.ApplyInstrumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyInstrumentMapper {
    long countByExample(ApplyInstrumentExample example);

    int deleteByExample(ApplyInstrumentExample example);

    int insert(ApplyInstrument record);

    int insertSelective(ApplyInstrument record);

    List<ApplyInstrument> selectByExample(ApplyInstrumentExample example);

    int updateByExampleSelective(@Param("record") ApplyInstrument record, @Param("example") ApplyInstrumentExample example);

    int updateByExample(@Param("record") ApplyInstrument record, @Param("example") ApplyInstrumentExample example);

    void batchInsert(@Param("items") List<ApplyInstrument> items);
}