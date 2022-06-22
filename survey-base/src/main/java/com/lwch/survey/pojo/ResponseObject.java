package com.lwch.survey.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001980000089929740L;

	/**
	 * http状态码
	 */
	private int http;
	
	/**
	 * 返回的具体数据
	 */
	private Object data;
	
	/**
	 * 返回的pie name
	 */
	private Object dataNames;

	/**
	 * 分页的总条数
	 */
	private Long count;
	
	/**
	 * 需要返回的说明和信息
	 */
	private String msg;
	
	/**
	 * 总页数
	 */
	private Integer pages;
	
	private int code;
	
	private int status;
	
	private long total;
	
	private String message;

	
}
