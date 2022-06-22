package com.lwch.survey.httpclient;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName:  HttpClientUtil
 * @Description:httpclient工具类
 * @date:   2019年1月8日 下午1:32:03       
 * @author: wangxuebo
 * @Copyright:  迅优智超
 */
@Component
public class HttpClientUtil
{
	@Autowired
	private RequestConfig config;

	@Autowired
	private CloseableHttpClient httpClient;

	/**
	 * @Title: requestParams   
	 * @Description:实体或者map转NameValuePair
	 * @param model
	 * @param list
	 * @throws Exception 
	 * @return void
	 * @author: 王雪波
	 * @date:   2019年1月8日 下午1:32:03
	 */
	private Map<String, String> requestParams(Object model, List<NameValuePair> list) throws Exception
	{
		Map<String, String> datas=new HashMap<>();
		if (null == model)
		{
			return datas;
		}
		if (model instanceof Map)
		{
			@SuppressWarnings("rawtypes")
			Map map = (Map) model;
			if (MapUtils.isEmpty(map))
			{
				return datas;
			}
			else
			{
				@SuppressWarnings(
				{ "unchecked", "rawtypes" })
				Set<Entry> set = map.entrySet();
				for (@SuppressWarnings("rawtypes")
				Entry entry : set)
				{
					Object keyObj = entry.getKey();
					Object valObj = entry.getValue();
					if (null != keyObj && null != valObj)
					{
						String key = keyObj.toString().trim();
						String val = valObj.toString().trim();
						BasicNameValuePair pair = new BasicNameValuePair(key, val);
						list.add(pair);
						datas.put(key, val);
					}
				}
			}
		}
		else
		{
			for (Field field : model.getClass().getDeclaredFields())
			{
				field.setAccessible(true);
				if (null == field.get(model))
				{
					continue;
				}
				datas.put(field.getName(), field.get(model).toString());
				
				BasicNameValuePair pair = new BasicNameValuePair(field.getName(), field.get(model).toString());
				list.add(pair);
			}
		}
		
		return datas;
	}

	/**
	 * @Title: getRequest   
	 * @Description:get请求
	 * @param url
	 * @param headers
	 * @param datas
	 * @return String
	 * @throws Exception
	 * @author: 王雪波
	 * @date:   2019年1月8日 下午1:32:03
	 */
	public CloseableHttpResponse getRequest(String url, Map<String, String> headers, Object datas) throws Exception
	{
		URIBuilder uriBuilder = new URIBuilder(url);
		List<NameValuePair> list = new ArrayList<>();
		requestParams(datas, list);

		uriBuilder.setParameters(list);

		HttpGet httpGet = new HttpGet(uriBuilder.build());

		if (MapUtils.isNotEmpty(headers))
		{
			Iterator<Entry<String, String>> iterator = headers.entrySet().iterator();
			while (iterator.hasNext())
			{
				Entry<String, String> entry = iterator.next();
				httpGet.addHeader(entry.getKey(), entry.getValue());
			}
		}

		// 装载配置信息
		httpGet.setConfig(config);
		// 发起请求
		return httpClient.execute(httpGet);
	}

	/**
	 * @Title: postRequest   
	 * @Description:post请求
	 * @param url
	 * @param headers
	 * @param datas
	 * @return String
	 * @throws Exception 
	 * @author: 王雪波
	 * @date:   2019年1月8日 下午1:32:03
	 */
	public CloseableHttpResponse postRequest(String url, Map<String, String> headers, Object datas) throws Exception
	{
		// 获取连接客户端工具
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建POST请求对象
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<>();

		Map<String, String> dts=requestParams(datas, list);

		StringEntity entity=new StringEntity(com.lwch.survey.utils.JsonUtil.getBeanToJson(dts));
		httpPost.setEntity(entity);

		if (MapUtils.isNotEmpty(headers))
		{
			Iterator<Entry<String, String>> iterator = headers.entrySet().iterator();
			while (iterator.hasNext())
			{
				Entry<String, String> entry = iterator.next();
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
		}

		// 执行请求
		return httpClient.execute(httpPost);
	}
	
	/**
	 * @Title: getRespBody   
	 * @Description:获取响应报文的报文体
	 * @param resp
	 * @return String
	 * @throws IOException 
	 * @author: 王雪波
	 * @date:   2020年9月2日 下午3:56:47
	 */
	public String getRespBody(CloseableHttpResponse resp) throws IOException
	{
		HttpEntity entity=resp.getEntity();
		return EntityUtils.toString(entity);
	}
}
