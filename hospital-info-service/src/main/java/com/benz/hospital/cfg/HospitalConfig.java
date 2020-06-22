package com.benz.hospital.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.benz.hospital.entity.Hospital;

@Configuration
@ComponentScan(basePackages="com.benz.hospital")
public class HospitalConfig {

	@Bean(name="Hospital")
	@Scope(value ="prototype")
	public Hospital getHospital()
	{
		return new Hospital();
	}
}
