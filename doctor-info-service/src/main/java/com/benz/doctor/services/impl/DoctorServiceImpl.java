package com.benz.doctor.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.doctor.dao.DoctorDAO;
import com.benz.doctor.entity.DocId;
import com.benz.doctor.entity.Doctor;
import com.benz.doctor.exception.DataNotFoundException;

@Service
public class DoctorServiceImpl{
	
	@Autowired
	DoctorDAO doctor_dao=null;

	public Doctor updateDoctor(Doctor doc) throws Exception
	{
		Doctor doctor=doctor_dao.findBySlmcRegNo(doc.getSlmcRegNo());
		
		Doctor n_doc=doctor_dao.getOne(new DocId(doctor.getDocId(),doctor.getSlmcRegNo()));
		
		if(n_doc!=null)
		{
		  n_doc.setDocName(doc.getDocName());
		  n_doc.setDistrict(doc.getDistrict());
		  n_doc.setEmail(doc.getEmail());
		  n_doc.setPnum(doc.getPnum());
		  n_doc.setSlmcRegNo(doc.getSlmcRegNo());
		  n_doc.setSpecialization(doc.getSpecialization());
		  n_doc.setHospital(doc.getHospital());
		  n_doc.setModifiedDate(new Date());
		  
			return n_doc;
		}else
			return doc;
	}
	
	
}
