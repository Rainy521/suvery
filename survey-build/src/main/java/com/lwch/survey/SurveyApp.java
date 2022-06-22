package com.lwch.survey;

import com.lwch.survey.interceptor.CredentialsNonExpiredIntercepter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class,
		  SecurityAutoConfiguration.class})
@Import(SwaggerConfiguration.class)
public class SurveyApp implements WebMvcConfigurer
{
	
	/*
	 * @Bean public FilterRegistrationBean<ParamFilter>
	 * filterRegistrationBean(ParamFilter paramFilter) {
	 * FilterRegistrationBean<ParamFilter> filterRegistrationBean = new
	 * FilterRegistrationBean<ParamFilter>();
	 * filterRegistrationBean.setFilter(paramFilter);
	 * filterRegistrationBean.setEnabled(true);
	 * filterRegistrationBean.addUrlPatterns("/*"); return filterRegistrationBean; }
	 */
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CredentialsNonExpiredIntercepter());
    }
	
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(SurveyApp.class, args);
	}
}
