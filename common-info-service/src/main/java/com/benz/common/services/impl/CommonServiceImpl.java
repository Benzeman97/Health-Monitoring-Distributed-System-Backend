package com.benz.common.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.benz.common.model.BMI;
import com.benz.common.model.Keto;
import com.benz.common.model.Planing;
import com.benz.common.model.TDEE;

@Service
public class CommonServiceImpl {
	

	public double getBMI(BMI bmi)
	{

		double height=((double)(bmi.getHeight()/100)*((double)bmi.getHeight()/100));
		
		double n_bmi=(double)(bmi.getWeight()/height);
		 
		return (double)Math.round(n_bmi*100)/100;
		
	}
	
	public long getTDEE(TDEE tdee)
	{
		double gen_tdee= getBMR(tdee.getHeight(),tdee.getWeight(),tdee.getAge())*getActivityLevel(tdee.getActivity());

		return Math.round(gen_tdee);
	}
	
	public double getBMR(int height,int weight,int age)
	{
		double bmr=(height*6.25)+(weight*9.99)-(age*4.92)-161;
		
		return bmr;
	}
	
	public double getActivityLevel(String activity)
	{
		double a_level=0;
		
		switch(activity)
		{
		case "sedentary": a_level=1.1;break;
		case "light exercise": a_level=1.275;break;
		case "heavy exercise":a_level=1.525;break;
		}
		
		return a_level;
	}
	public Planing getPlaning(Keto keto)
	{
		String[] meats=keto.getMeat().split(",");
		String[] veggies=keto.getVeggies().split(",");
		String[] products=keto.getProducts().split(",");
	
		Keto keto_plan_mon_break=new Keto();
		
		keto_plan_mon_break.setpActivity(keto.getpActivity());
		keto_plan_mon_break.setDay("Monday");
		keto_plan_mon_break.setWhich("Breakfast");
		keto_plan_mon_break.setMeat(meats[2]);
		keto_plan_mon_break.setVeggies(veggies[2]);
		keto_plan_mon_break.setProducts(products[3]);
		
         Keto keto_plan_mon_lunch=new Keto();
		
         keto_plan_mon_lunch.setpActivity(keto.getpActivity());
		keto_plan_mon_lunch.setDay("Monday");
		keto_plan_mon_lunch.setWhich("Lunch");
		keto_plan_mon_lunch.setMeat(meats[1]);
		keto_plan_mon_lunch.setVeggies(veggies[2]);
		keto_plan_mon_lunch.setProducts(products[1]);
		
        Keto keto_plan_mon_dinner=new Keto();
		
        keto_plan_mon_dinner.setpActivity(keto.getpActivity());
		keto_plan_mon_dinner.setDay("Monday");
		keto_plan_mon_dinner.setWhich("Dinner");
		keto_plan_mon_dinner.setMeat(meats[2]);
		keto_plan_mon_dinner.setVeggies(veggies[1]);
		keto_plan_mon_dinner.setProducts(products[2]);
		
		List<Keto> ketos=new ArrayList<Keto>();
		ketos.add(keto_plan_mon_break);
		ketos.add(keto_plan_mon_lunch);
		ketos.add(keto_plan_mon_dinner);
		
		Planing plan=new Planing();
		plan.setKetos(ketos);
		
		return plan;
		
	}
}
