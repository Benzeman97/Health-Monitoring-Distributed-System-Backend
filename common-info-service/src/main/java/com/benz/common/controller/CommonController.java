package com.benz.common.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.common.exception.DataNotFoundException;
import com.benz.common.model.BMI;
import com.benz.common.model.Keto;
import com.benz.common.model.Planing;
import com.benz.common.model.TDEE;
import com.benz.common.services.CommonService;

@CrossOrigin
@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	CommonService common_service;

	@PostMapping("/keto")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Planing getPlaning(@RequestBody Keto keto)
	{
		
		if(keto!=null)
		return common_service.getPlanning(keto);
		else
			throw new DataNotFoundException("Data Not Available");
		
	}
	
	@PostMapping("/bmi")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public BMI getBMI(@RequestBody BMI bmi)
	{
		if(bmi!=null)
		return common_service.getBMI(bmi);
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	@PostMapping("/tdee")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public TDEE getTDEE(@RequestBody TDEE tdee)
	{
		if(tdee!=null)
		return common_service.getTDEE(tdee);
		else
			throw new DataNotFoundException("Data Not Available");
	}
}
