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
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.github.pagehelper.PageInterceptor;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = ViewDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "viewSqlSessionFactory")
public class ViewDataSourceConfig
{
	static final String PACKAGE = "com.lwch.survey.dao.view";
	
	static final String MAPPER_LOCATION = "classpath:mapper/view/**/*.xml";
	
	@Value("${spring.datasource.view.url}")
	private String url;

	@Value("${spring.datasource.view.username}")
	private String user;

	@Value("${spring.datasource.view.password}")
	private String password;

	@Value("${spring.datasource.view.driverClassName}")
	private String driverClass;
	
	/**
	 * @Title: viewDataSource   
	 * @Description:druid连接池设置 
	 * @return: DataSource      
	 * @throws:SQLException
	 */
	@Bean(name = "viewDataSource")
	@Qualifier("viewDataSource")
	public DataSource viewDataSource() throws SQLException
	{
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(5);
		ds.setMinIdle(5);
		ds.setMaxActive(10);
		ds.setMaxWait(60000);
		//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		ds.setTimeBetweenEvictionRunsMillis(60000);
		//配置一个连接在池中最小生存的时间，单位是毫秒
		ds.setMinEvictableIdleTimeMillis(300000);
		//打开PSCache，并且指定每个连接上PSCache的大小
		ds.setPoolPreparedStatements(true);
		ds.setMaxPoolPreparedStatementPerConnectionSize(2);

		ds.setValidationQuery("SELECT 1  from  DUAL ");
		ds.setTestWhileIdle(true);
		ds.setTestOnBorrow(false);
		ds.setTestOnReturn(false);

		//配置监控统计拦截的filters
		ds.setFilters("stat");
		//超过时间限制是否回收
		ds.setRemoveAbandoned(true);
		//超时时间；单位为秒。180秒=3分钟
		ds.setRemoveAbandonedTimeout(180);
		//关闭abanded连接时输出错误日志
		ds.setLogAbandoned(true);
		return ds;
	}

	@Bean(name = "viewSqlSessionFactory")
	public SqlSessionFactory viewSqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(viewDataSource());
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(ViewDataSourceConfig.MAPPER_LOCATION));
		org.apache.ibatis.session.Configuration ibatisConfiguration = new org.apache.ibatis.session.Configuration();
		ibatisConfiguration.setCallSettersOnNulls(true);
		ibatisConfiguration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
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
	 * @Title: druidServlet
	 * @Description:druid监控访问
	 * @param: @return      
	 * @return: ServletRegistrationBean
	 * @throws
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> druidServlet()
	{
		ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("loginUsername", user);
		reg.addInitParameter("loginPassword", password);
		reg.addInitParameter("resetEnable", "false");
		return reg;
	}

	@Bean(name = "viewSqlSessionTemplate")
	public SqlSessionTemplate viewSqlSessionTemplate() throws Exception
	{
		return new SqlSessionTemplate(viewSqlSessionFactory());
	}
	
	@Bean(name = "viewJdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("viewDataSource") DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
//	@Bean(name = "viewTransactionManager")
//	public PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("viewDataSource") DataSource dataSource)
//	{
//		return new DataSourceTransactionManager(dataSource);
//	}
}
