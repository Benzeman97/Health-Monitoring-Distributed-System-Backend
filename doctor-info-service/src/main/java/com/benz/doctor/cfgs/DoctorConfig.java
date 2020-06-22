package com.benz.doctor.cfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.benz.doctor.entity.Doctor;

@Configuration
@ComponentScan(basePackages={"com.benz.doctor"})
public class DoctorConfig {

	@Bean(name="Doctor")
	@Scope(value="prototype")
	public Doctor getDoctor()
	{
		return new Doctor();
	}
	
}
