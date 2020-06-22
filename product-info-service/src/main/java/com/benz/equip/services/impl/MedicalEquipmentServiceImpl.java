package com.benz.equip.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.equip.dao.EquipmentDAO;
import com.benz.equip.entity.Equipment;

@Service
public class MedicalEquipmentServiceImpl {

	@Autowired
	EquipmentDAO equipment_dao=null;
	
	public Equipment saveEquipment(Equipment equipment)
	{
		try {
			return equipment_dao.save(equipment);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
