package com.lwch.survey.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * 
 * @ClassName: JsonUtil
 * @Description: JSON工具类
 * @author: yangchao
 * @date: 2020年7月14日 上午11:29:45
 *
 * @Copyright: 2020 www.sys-test.com.cn Inc. All rights reserved.
 *             注意：本内容仅限于南京讯优智超软件科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class JsonUtil {

	/**
	 * 功能描述：把JSON数据转换成指定的java对象
	 * 
	 * @param jsonData JSON数据
	 * @param clazz    指定的java对象
	 * @return 指定的java对象
	 */
	public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
		return JSON.parseObject(jsonData, clazz);
	}

	/**
	 * 功能描述：把java对象转换成JSON数据
	 * 
	 * @param object java对象
	 * @return JSON数据
	 */
	public static String getBeanToJson(Object object) {
		return JSON.toJSONString(object);
	}

	/**
	 * 功能描述：把JSON数据转换成指定的java对象列表
	 * 
	 * @param jsonData JSON数据
	 * @param clazz    指定的java对象
	 * @return List<T>
	 */
	public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
		return JSON.parseArray(jsonData, clazz);
	}

	/**
	 * 功能描述：把JSON数据转换成较为复杂的List<Map<String, Object>>
	 * 
	 * @param jsonData JSON数据
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, String>> getJsonToListMap(String jsonData) {
		return JSON.parseObject(jsonData, new TypeReference<List<Map<String, String>>>() {});
	}
	
	/**
	 * 功能描述：把JSON数据转换成较为复杂的Map<String, Object>
	 * 
	 * @param jsonData JSON数据
	 * @return Map<String, Object>
	 */
	public static Map<String, String> getJsonToMap(String jsonData) {
		return JSON.parseObject(jsonData, new TypeReference<Map<String, String>>() {});
	}
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	/**
	 * @Title: writeValueAsString   
	 * @Description:对象转json字符串
	 * @param: obj
	 * @param:  String
	 * @param: JsonProcessingException    
	 * @return: String      
	 * @throws:JsonProcessingException
	 */
	public static String writeValueAsString(Object obj) throws JsonProcessingException
	{
		if (null != obj)
		{
		    MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            MAPPER.registerModule(new JavaTimeModule());
			return MAPPER.writeValueAsString(obj);
		}
		return "";
	}
}
