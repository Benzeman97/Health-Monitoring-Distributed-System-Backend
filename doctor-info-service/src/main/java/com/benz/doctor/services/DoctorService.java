package com.benz.doctor.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.benz.doctor.dao.DoctorDAO;
import com.benz.doctor.entity.Doctor;
import com.benz.doctor.exception.DataNotFoundException;
import com.benz.doctor.model.DoctorSpecialization;
import com.benz.doctor.services.impl.DoctorServiceImpl;

@Service
public class DoctorService {
	
	@Autowired
	DoctorServiceImpl doctor_service_impl=null;
	
	@Autowired
	 DoctorDAO doctor_dao;

	public Doctor saveDoctor(Doctor doctor)
	{
		try{
		   doctor.setCreated_date(new Date());
		   return doctor_dao.save(doctor);
               
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public Doctor getDoctor(String regNo)
	{
		return doctor_dao.findBySlmcRegNo(regNo);
		
	}
	
	public Doctor updateDoctor(Doctor doc) throws Exception
	{
            
		doc= doctor_service_impl.updateDoctor(doc);
		
		return doctor_dao.save(doc);
		
	}
	
	public void deleteDoctor(String regNo)
	{
		Doctor doctor=doctor_dao.findBySlmcRegNo(regNo);
		
		if(doctor!=null)
		doctor_dao.delete(doctor); 
		else 
			throw new DataNotFoundException("Data Not Available");
		
	}
	
	public List<Doctor> getDoctors()
	{
		try {
		return doctor_dao.findAll();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public DoctorSpecialization getDoctors(String specialization)
	{
		List<Doctor> doctors=doctor_dao.findBySpecialization(specialization);
		
		if(doctors.size()!=0)
		{
			DoctorSpecialization doctorSpecialization=new DoctorSpecialization();
				doctorSpecialization.setDoctors(doctors);
				return doctorSpecialization;
		}else
			return null;
	}
	
}
