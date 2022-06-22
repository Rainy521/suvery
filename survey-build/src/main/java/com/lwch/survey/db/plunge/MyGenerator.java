package com.lwch.survey.db.plunge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

/**
 * @ClassName:  MyGenerator
 * @Description:mybatis实体、映射文件生成类
 * @date:   2019年4月2日 上午10:35:25       
 * @author: 王雪波
 * @Copyright:  讯优智超
 */
public class MyGenerator
{
	private MyGenerator()
	{
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("****开始*****");
			List<String> warnings = new ArrayList<>();
			boolean overwrite = true;
			File configFile =ResourceUtils.getFile("classpath:generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("****结束*****");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
