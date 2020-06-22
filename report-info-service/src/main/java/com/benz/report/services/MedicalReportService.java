package com.benz.report.services;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.benz.report.entity.Report;
import com.benz.report.model.BloodSugar;
import com.benz.report.model.DoctorSpecialization;
import com.benz.report.model.DoctorsAndProducts;
import com.benz.report.model.LipidProfile;
import com.benz.report.model.ProductCategory;
import com.benz.report.services.impl.MedicalReportServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Service
public class MedicalReportService {

	@Autowired
	MedicalReportServiceImpl medical_report_service_impl=null;
	
	@Autowired
    RestTemplate restTemplate;
	
	@Value("${doctor.details.url}")
	String doctor_details_url;
	
	@Value("${product.details.url}")
	String product_details_url;
	
	public Report saveMedicalReport(Report report)
	{
		return medical_report_service_impl.saveMedicalReport(report);
	}
	
	public Report updateReport(Report report) throws BeansException, Exception
	{
	
		return medical_report_service_impl.updateReport(report);
	}
	
	//circuit breaker pattern
	@HystrixCommand(fallbackMethod="getfallBackdisplayDoctorsAndProducts_lipid",
			commandProperties= {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="150"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="25"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")
			})
	public List<DoctorsAndProducts> displayDoctorsAndProducts(LipidProfile lipidProfile)
	{
		
		if(medical_report_service_impl.isPatient(lipidProfile))
		{
			DoctorSpecialization specializations=restTemplate.getForObject(doctor_details_url+"/cardiologist", DoctorSpecialization.class);
			
			ProductCategory categories=restTemplate.getForObject(product_details_url+"/lipid",ProductCategory.class);
			
			List<DoctorsAndProducts> doctors_products=medical_report_service_impl.displayDoctorsAndProducts(specializations, categories);
		
			if(doctors_products.size()!=0)
				return doctors_products;
			else
				return null;
		}
		return null;
		
	}
	
	public List<DoctorsAndProducts> getfallBackdisplayDoctorsAndProducts_lipid(LipidProfile lipidProfile)
	{
		if(medical_report_service_impl.isPatient(lipidProfile))
		{
			return medical_report_service_impl.getFallbackdisplayDoctorsAndProducts_lipid();
		}
		return null;
		
	}
	
	//bulkhead pattern
	@HystrixCommand(fallbackMethod="getFallbackdisplayDoctorsAndProducts_diabetes",
			threadPoolKey="doctorsProductsPool",
			threadPoolProperties= {
				@HystrixProperty(name="coreSize",value="20"),
				@HystrixProperty(name="maxQueueSize",value="10")
	})
	public List<DoctorsAndProducts> displayDoctorsAndProducts(BloodSugar bloodSugar)
	{
		if(medical_report_service_impl.isPatient(bloodSugar))
		{
        DoctorSpecialization specializations=restTemplate.getForObject(doctor_details_url+"/diabetologist", DoctorSpecialization.class);
			
			ProductCategory categories=restTemplate.getForObject(product_details_url+"/diabetes",ProductCategory.class);
		
			List<DoctorsAndProducts> doctors_products=medical_report_service_impl.displayDoctorsAndProducts(specializations, categories);

			if(doctors_products.size()!=0)
				return doctors_products;
			else
				return null;
		
		}
		return null;
	}
	
	
	public List<DoctorsAndProducts> getFallbackdisplayDoctorsAndProducts_diabetes(BloodSugar bloodSugar)
	{
		return medical_report_service_impl.getFallbackdisplayDoctorsAndProducts_diabetes();
	}
}
