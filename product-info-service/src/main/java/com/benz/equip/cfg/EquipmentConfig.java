package com.benz.equip.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.benz.equip.entity.Equipment;

@Configuration
public class EquipmentConfig {

	@Bean(name="Equipment")
	@Scope(value="prototype")
	public Equipment getEquipment()
	{
		return new Equipment();
	}
}
