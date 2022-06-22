package com.lwch.survey.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PieData implements Serializable{

	/**
	 * serId
	 */
	private static final long serialVersionUID = 2385011534561439688L;

	private String name;
	
	private Double value;
	
	private Integer count;
	
	private List<StatisticsInfo> statisticses = new ArrayList<>();

	public List<StatisticsInfo> getStatisticses() {
		return statisticses;
	}

	public void setStatisticses(List<StatisticsInfo> statisticses) {
		this.statisticses = statisticses;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
