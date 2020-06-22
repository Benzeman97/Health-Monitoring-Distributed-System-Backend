package com.benz.hospital.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.hospital.dao.HospitalDAO;
import com.benz.hospital.entity.Hospital;
import com.benz.hospital.exception.DataNotFoundException;

@Service
public class HospitalServiceImpl {

	
	@Autowired
	HospitalDAO hospital_dao=null;
	
	public Hospital saveHospital(Hospital hospital)
	{
		try {
			return hospital_dao.save(hospital);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public Hospital updateHospital(Hospital hos)
	{
		Hospital hospital = hospital_dao.getOne(hos.getHospitalName());
		
		 hospital.setHospitalType(hos.getHospitalType());
		 
		 if(!hospital.getHospitalName().equalsIgnoreCase(hos.getHospitalName()))
		    throw new DataNotFoundException("Data Not Available For "+hos.getHospitalName());
		 else
			 return hospital_dao.save(hospital);
	}
}
