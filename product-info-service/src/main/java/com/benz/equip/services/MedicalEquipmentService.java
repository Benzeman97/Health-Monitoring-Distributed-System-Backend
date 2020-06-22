package com.benz.equip.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.equip.entity.Equipment;
import com.benz.equip.services.impl.MedicalEquipmentServiceImpl;


@Service
public class MedicalEquipmentService {

	@Autowired
	MedicalEquipmentServiceImpl medical_equip_service_impl=null;
	
	public Equipment saveEquipment(Equipment equipment)
	{
		return medical_equip_service_impl.saveEquipment(equipment);
	}
	
}
