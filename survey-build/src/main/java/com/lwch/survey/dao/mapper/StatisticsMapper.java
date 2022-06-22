package com.lwch.survey.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwch.survey.pojo.StatisticsInfo;
import com.lwch.survey.pojo.StatisticsParam;

public interface StatisticsMapper {
	
	List<StatisticsInfo> queryStatistics(StatisticsParam param);
	
	List<StatisticsInfo> queryStatisticsChlx(@Param("chlx") String chlx);
	
}