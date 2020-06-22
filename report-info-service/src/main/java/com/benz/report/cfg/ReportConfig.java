package com.benz.report.cfg;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.benz.report.entity.Report;

@Configuration
@ComponentScan(basePackages= "{com.benz.report.model}")
public class ReportConfig {

	@Bean(name="Report")
	@Scope(value = "prototype")
	public Report getReport()
	{
		return new Report();
	}
	
	@LoadBalanced
	@Bean
	@Scope(value = "prototype")
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
}
