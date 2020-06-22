package com.benz.common.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.common.exception.DataNotFoundException;
import com.benz.common.model.BMI;
import com.benz.common.model.Keto;
import com.benz.common.model.Planing;
import com.benz.common.model.TDEE;
import com.benz.common.services.impl.CommonServiceImpl;

@Service
public class CommonService {
	
	@Autowired
	CommonServiceImpl common_service_impl;
	
	

	public Planing getPlanning(Keto keto)
	{
		Planing plan=common_service_impl.getPlaning(keto);
		
		if(plan!=null)
		return plan;
		else
			throw new DataNotFoundException("Data Not Available");
		
	}
	
	public BMI getBMI(BMI bmi)
	{
		 bmi.setResult(common_service_impl.getBMI(bmi));
		return bmi;
	}
	
	public TDEE getTDEE(TDEE tdee)
	{
		tdee.setResult(common_service_impl.getTDEE(tdee));
		return tdee;
	}
}
