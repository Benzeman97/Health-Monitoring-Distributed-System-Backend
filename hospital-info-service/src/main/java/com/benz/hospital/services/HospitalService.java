package com.benz.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.benz.hospital.dao.HospitalDAO;
import com.benz.hospital.entity.Hospital;
import com.benz.hospital.services.impl.HospitalServiceImpl;

@Service
public class HospitalService {

	@Autowired
	HospitalServiceImpl hospital_service_impl=null;
	
	@Autowired
	HospitalDAO hospital_dao;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospital_service_impl.saveHospital(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital)
	{
		return hospital_service_impl.updateHospital(hospital);
	}
	
	public Hospital getHospital(String name)
	{
		return hospital_dao.findByHospitalName(name);
	}
	
	public void deleteHospital(String name)
	{
		Hospital hospital=hospital_dao.findByHospitalName(name);
		
		hospital_dao.delete(hospital);
	}
	
	public List<Hospital> getHospitals()
	{
		try {
		return hospital_dao.findAll();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
