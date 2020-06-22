package com.benz.equip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.equip.cfg.EquipmentConfig;
import com.benz.equip.entity.Equipment;
import com.benz.equip.exception.DataNotFoundException;
import com.benz.equip.services.MedicalEquipmentService;

@RestController
@RequestMapping("/equipment")
public class MedicalEquipmentController {

	ApplicationContext context =null;
	
	@Autowired
	MedicalEquipmentService medical_equipment_service=null;
	
	@RequestMapping("/save/{name}/{price}/{brand}")
	public Equipment saveEquipment(@PathVariable("name") String name,@PathVariable("price") double price,
			@PathVariable("brand") String brand)
	{
		context=new AnnotationConfigApplicationContext(EquipmentConfig.class);
		
		Equipment equipment =context.getBean(Equipment.class);
		equipment.setName(name);
		equipment.setPrice(price);
		equipment.setBrand(brand);
		
		if(equipment.getName().trim().isEmpty()||equipment.getPrice()==0.0||equipment.getBrand().trim().isEmpty())
		     throw new NullPointerException();
		else
			equipment=medical_equipment_service.saveEquipment(equipment);
		
		if(equipment!=null)
			return equipment;
		else
			throw new DataNotFoundException("Data Not Found For "+name);
	}
	
}
