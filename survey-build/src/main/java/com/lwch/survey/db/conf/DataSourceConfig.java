package com.lwch.survey.db.conf;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

/**
 * @ClassName:  DataSourceConfig
 * @Description:本地数据源配置类
 * @date:   2019年4月2日 上午10:31:08       
 * @author: 王雪波
 * @Copyright:  讯优智超
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "localSqlSessionFactory")
public class DataSourceConfig
{
	/** 精确到 master 目录，以便跟其他数据源隔离*/
	static final String PACKAGE = "com.lwch.survey.dao.mapper";
	/**mapper映射文件的相对路径 */
	static final String MAPPER_LOCATION = "classpath:mapper/local/**/*.xml";

	@Value("${spring.datasource.local.url}")
	private String url;

	@Value("${spring.datasource.local.username}")
	private String user;

	@Value("${spring.datasource.local.password}")
	private String password;

	@Value("${spring.datasource.local.driverClassName}")
	private String driverClass;

	/**
	 * @Title: localDataSource   
	 * @Description:druid连接池设置
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: DataSource      
	 * @throws
	 */
	@Bean(name = "localDataSource")
	@Qualifier("localDataSource")
	@Primary
	public DataSource localDataSource() throws SQLException
	{
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(5);
		ds.setMinIdle(5);
		ds.setMaxActive(10);
		ds.setMaxWait(6000);
		//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		ds.setTimeBetweenEvictionRunsMillis(60000);
		//配置一个连接在池中最小生存的时间，单位是毫秒
		ds.setMinEvictableIdleTimeMillis(300000);
		//打开PSCache，并且指定每个连接上PSCache的大小
		ds.setPoolPreparedStatements(true);
		ds.setMaxPoolPreparedStatementPerConnectionSize(20);

		ds.setValidationQuery("SELECT 1 ");
		ds.setTestWhileIdle(true);
		ds.setTestOnBorrow(false);
		ds.setTestOnReturn(false);

		//配置监控统计拦截的filters
		ds.setFilters("stat");
		//超过时间限制是否回收
		ds.setRemoveAbandoned(true);
		//超时时间；单位为秒
		ds.setRemoveAbandonedTimeout(1800);
		//关闭abanded连接时输出错误日志
		ds.setLogAbandoned(true);
		return ds;
	}

	/**
	 * @Title: localSqlSessionFactory   
	 * @Description:SqlSessionFactory设置并返回实例
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: SqlSessionFactory      
	 * @throws
	 */
	
	@Bean(name = "localSqlSessionFactory")
	public SqlSessionFactory localSqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(localDataSource());
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
		org.apache.ibatis.session.Configuration ibatisConfiguration = new org.apache.ibatis.session.Configuration();
		ibatisConfiguration.setCallSettersOnNulls(true);
		//ibatisConfiguration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
		factoryBean.setConfiguration(ibatisConfiguration);

		//分页插件
		PageInterceptor pageHelper = pageInterceptor();
		//mybatis插件
		factoryBean.setPlugins(new Interceptor[]{ pageHelper});
		return factoryBean.getObject();

	}
	
	/**
	 * @Title: pageInterceptor   
	 * @Description:实例化pageInterceptor
	 * @param: @return      
	 * @return: PageHelper      
	 * @throws
	 */
	public PageInterceptor pageInterceptor()
	{
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageInterceptor.setProperties(p);
		return pageInterceptor;
	}

	/**
	 * @Title: localSqlSessionTemplate   
	 * @Description:返回SqlSessionTemplate
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: SqlSessionTemplate      
	 * @throws
	 */
	@Bean(name = "localSqlSessionTemplate")
	public SqlSessionTemplate localSqlSessionTemplate() throws Exception
	{
		return new SqlSessionTemplate(localSqlSessionFactory());
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("localDataSource") DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("localDataSource") DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}
}
