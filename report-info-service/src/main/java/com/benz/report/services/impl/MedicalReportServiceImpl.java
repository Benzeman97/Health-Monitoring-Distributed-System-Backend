package com.benz.report.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.benz.report.dao.ReportDAO;
import com.benz.report.entity.Report;
import com.benz.report.model.BloodSugar;
import com.benz.report.model.DoctorSpecialization;
import com.benz.report.model.DoctorsAndProducts;
import com.benz.report.model.LipidProfile;
import com.benz.report.model.ProductCategory;

@Service
public class MedicalReportServiceImpl {

	@Autowired
	ReportDAO report_dao=null;
	
	
	public Report updateReport(Report report) throws Exception
	{
		Report n_report=report_dao.getReportByPatientName(report.getPatientName());
		
		n_report.setReportType(report.getReportType());
		n_report.setHospital(report.getHospital());
		n_report.setReportDate(new Date());
		n_report.setPatientName(report.getPatientName());
		
		return report_dao.save(n_report);
	}
	
	public Report saveMedicalReport(Report report)
	{
		try {
			return report_dao.save(report);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean isPatient(LipidProfile lipidProfile)
	{
		boolean patient=false;
		
		if(lipidProfile.getHdl_chole()>250)
			patient= true;
		else
			if(lipidProfile.getLdl_chole()>160)
				patient= true;
			else
		if(lipidProfile.getTrigly()>160)
			patient= true;
		
		return patient;
		
	
	}
	
	public boolean isPatient(BloodSugar bloodSugar)
	{
		boolean patient=false;
		
		if(bloodSugar.getTestType().equalsIgnoreCase("FBC"))
		{
			if(Integer.parseInt(bloodSugar.getResult())>=140)
				patient=true;
		}
		
		return patient;
	}
	public List<DoctorsAndProducts> displayDoctorsAndProducts(DoctorSpecialization specializations,ProductCategory categories)
	{
		int s_size=specializations.getDoctors().size();
		
		int c_size=categories.getProduct().size();
		
		if(s_size>=3 && c_size>=3)
		{
			List<DoctorsAndProducts> doctors_products=new ArrayList<DoctorsAndProducts>();
			
			for(int i=0;i<3;i++)
			{
				DoctorsAndProducts doctor_product=new DoctorsAndProducts();
				
				doctor_product.setDocName(specializations.getDoctors().get(i).getDocName());
				doctor_product.setSlmcRegNo(specializations.getDoctors().get(i).getSlmcRegNo());
				doctor_product.setHospital(specializations.getDoctors().get(i).getHospital());
				doctor_product.setSpecialization(specializations.getDoctors().get(i).getSpecialization());
			    doctor_product.setProductId(categories.getProduct().get(i).getProductId());
			    doctor_product.setProductName(categories.getProduct().get(i).getProductName());
			    doctor_product.setMadeBy(categories.getProduct().get(i).getMadeBy());
			    doctor_product.setPrice(categories.getProduct().get(i).getPrice());
			    
			    doctors_products.add(doctor_product);
			}
			return doctors_products;
		}else
			return null;
	
	}
	
	public List<DoctorsAndProducts> getFallbackdisplayDoctorsAndProducts_lipid()
	{
		
		List<DoctorsAndProducts> doctors_products=new ArrayList<DoctorsAndProducts>();

		DoctorsAndProducts doctor_product = new DoctorsAndProducts();
		
		doctor_product.setDocName("Dr. RajaKaruna");
		doctor_product.setSlmcRegNo("Col0967");
		doctor_product.setHospital("Genreal Hospital Colombo");
		doctor_product.setSpecialization("Cardilogist");
	    doctor_product.setProductId(1098);
	    doctor_product.setProductName("Blood Pressure Meter");
	    doctor_product.setMadeBy("India");
	    doctor_product.setPrice(7800);
	    
	    doctors_products.add(doctor_product);
	    
	    return doctors_products;
	}
	
	public List<DoctorsAndProducts> getFallbackdisplayDoctorsAndProducts_diabetes()
	{
		
		List<DoctorsAndProducts> doctors_products=new ArrayList<DoctorsAndProducts>();

	DoctorsAndProducts doctor_product = new DoctorsAndProducts();
	
	doctor_product.setDocName("Dr. Rajasinghe");
	doctor_product.setSlmcRegNo("CTR78646");
	doctor_product.setHospital("Nagaoda Distric Hospital");
	doctor_product.setSpecialization("Diabetologist");
    doctor_product.setProductId(1022);
    doctor_product.setProductName("Glucometer");
    doctor_product.setMadeBy("Malaysia");
    doctor_product.setPrice(3450.00);
    
      doctors_products.add(doctor_product);
      
     return doctors_products;
	}
}
