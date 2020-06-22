package com.benz.hospital.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.hospital.entity.Hospital;
import com.benz.hospital.exception.DataNotFoundException;
import com.benz.hospital.services.HospitalService;

@CrossOrigin
@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	ApplicationContext context=null;
	
	@Autowired
	HospitalService hospital_service=null;

	@RequestMapping("/save")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital saveHospital(@RequestBody Hospital hospital)
	{

	    hospital = hospital_service.saveHospital(hospital);
		
		if(hospital!=null)
			return hospital;
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	@PutMapping("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital updateHospital(@RequestBody Hospital hospital) throws Exception
	{
		System.out.println(hospital.getHospitalName());
			return hospital_service.updateHospital(hospital);
	
	}
	
	@GetMapping("/{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital getHospital(@PathVariable("name") String name)
	{
		return hospital_service.getHospital(name);
	}
	
	
	@DeleteMapping("delete/{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteHospital(@PathVariable("name") String name)
	{
		 hospital_service.deleteHospital(name);
	}
	
	@GetMapping("/all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Hospital> getHospitals()
	{
		List<Hospital> hospitals=hospital_service.getHospitals();
		
		if(hospitals.size()!=0)
			return hospitals;
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	
}
