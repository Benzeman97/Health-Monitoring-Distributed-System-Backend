package com.benz.user.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.benz.user.entity.User;


@Configuration
@ComponentScan(basePackages= {"com.benz.user.model"})
public class UserConfig {

	@Bean(name="User")
	@Scope(value="prototype")
	public User getUser()
	{
		return new User();
	}
	
	
	
	/*
	 * @Bean(name="view")
	 * 
	 * @Scope(value="singleton") public InternalResourceViewResolver getView() {
	 * 
	 * InternalResourceViewResolver view= new InternalResourceViewResolver();
	 * view.setPrefix("/WEB-INF/"); view.setSuffix(".jsp"); return view; }
	 */
}
