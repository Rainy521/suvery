package com.lwch.survey.pojo;

import java.io.Serializable;
import java.util.Date;

public class StatisticsInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 识别id */
	private String id;
	
	/** 建设单位 */
	private String jsdw;
	
	/** 楼盘幢号 */
	private String lpzh;
	
	/** 受理单位 */
	private String sldw;
	
	/** 建筑面积 */
	private Double jzmj;
	
	/** 受理时间 */
	private String slsj;
	
	/** 测绘类型 */
	private String chlx;
	
	/** 更新时间 */
	private Date updateTime;
	
	/** 月度统计(分组字段) */
	private String monthDay;
	
	/** 年度统计(分组字段) */
	private String yearDay;
	
	/** 季度统计(分组字段) */
	private String quarterDay;
	
	public String getChlx() {
		return chlx;
	}

	public void setChlx(String chlx) {
		this.chlx = chlx;
	}

	public String getLpzh() {
		return lpzh;
	}

	public void setLpzh(String lpzh) {
		this.lpzh = lpzh;
	}

	public String getMonthDay() {
		return monthDay;
	}

	public void setMonthDay(String monthDay) {
		this.monthDay = monthDay;
	}

	public String getYearDay() {
		return yearDay;
	}

	public void setYearDay(String yearDay) {
		this.yearDay = yearDay;
	}

	public String getQuarterDay() {
		return quarterDay;
	}

	public void setQuarterDay(String quarterDay) {
		this.quarterDay = quarterDay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsdw() {
		return jsdw;
	}

	public void setJsdw(String jsdw) {
		this.jsdw = jsdw;
	}

	public String getSldw() {
		return sldw;
	}

	public void setSldw(String sldw) {
		this.sldw = sldw;
	}

	public Double getJzmj() {
		return jzmj;
	}

	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
	}

	public String getSlsj() {
		return slsj;
	}

	public void setSlsj(String slsj) {
		this.slsj = slsj;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
