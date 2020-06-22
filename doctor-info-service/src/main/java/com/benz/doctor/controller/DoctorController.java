package com.benz.doctor.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.doctor.entity.Doctor;
import com.benz.doctor.exception.DataNotFoundException;
import com.benz.doctor.model.DoctorSpecialization;
import com.benz.doctor.services.DoctorService;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController{

	
	@Autowired
	DoctorService doctor_service=null;
	
	@RequestMapping("/save")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Doctor saveDoctor(@RequestBody Doctor doctor)
	{
		
		 
		doctor = doctor_service.saveDoctor(doctor);
		
		if(doctor!=null)
			return doctor;
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	@PutMapping("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Doctor updateDoctor(@RequestBody Doctor doctor) throws Exception
	{
		
			return doctor_service.updateDoctor(doctor);
		
	}
	
	@GetMapping("get/{regNo}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Doctor getDoctor(@PathVariable("regNo") String regNo)
	{
		return doctor_service.getDoctor(regNo);
	}
	
	@DeleteMapping("/delete/{regNo}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteDoctor(@PathVariable("regNo") String regNo)
	{
		doctor_service.deleteDoctor(regNo);
	}
	
	@GetMapping("/all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Doctor> getDoctors()
	{
		List<Doctor> doctors=doctor_service.getDoctors();
		
		if(doctors.size()!=0)
			return doctors;
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	@GetMapping("/{specialization}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public DoctorSpecialization getDoctors(@PathVariable("specialization") String specialization)
	{
		if(!specialization.trim().isEmpty())
		return doctor_service.getDoctors(specialization);
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
}
