package com.benz.report.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.report.entity.Report;
import com.benz.report.exception.DataNotFoundException;
import com.benz.report.model.BloodSugar;
import com.benz.report.model.DoctorsAndProducts;
import com.benz.report.model.LipidProfile;
import com.benz.report.services.MedicalReportService;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class MedicalReportController {

	ApplicationContext context=null;
	
	@Autowired
	MedicalReportService medical_report_service=null;
	
	
	@PostMapping("/lipidProfile")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XHTML_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DoctorsAndProducts> displayDoctorsAndProducts(@RequestBody LipidProfile lipidProfile)
	{
		if(lipidProfile!=null)
		return medical_report_service.displayDoctorsAndProducts(lipidProfile);
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	@PostMapping("/bloodSugar")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DoctorsAndProducts> displayDoctorsAndProducts(@RequestBody BloodSugar bloodSugar)
	{
		if(bloodSugar!=null)
			return medical_report_service.displayDoctorsAndProducts(bloodSugar);
		else 
			throw new DataNotFoundException("Data Not Available");
	}
	
	@RequestMapping("/save/{r_type}/{hospital}/{p_name}/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Report saveReport(@PathVariable("r_type")String r_type,
			@PathVariable("hospital")String hospital,@PathVariable("p_name")String p_name)
	{
		Report report=context.getBean(Report.class);
		
		report.setReportType(r_type);
		report.setHospital(hospital);
		report.setReportDate(new Date());
		report.setPatientName(p_name);
		
		if(report.getReportType().trim().isEmpty() || report.getHospital().trim().isEmpty()||report.getPatientName().trim().isEmpty())
                throw new NullPointerException();
		else
			report=medical_report_service.saveMedicalReport(report);
		
		
		if(report!=null)
			return report;
		else
			throw new DataNotFoundException("Data Not Available For "+p_name);
	
	}
	
	@RequestMapping("/update/{r_type}/{hospital}/{p_name}/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Report updateReport(String r_type,String hospital,String p_name) throws BeansException, Exception
	{
		Report report=context.getBean(Report.class);
		
		report.setReportType(r_type);
		report.setHospital(hospital);
		report.setReportDate(new Date());
		report.setPatientName(p_name);
		
		if(report.getReportType().trim().isEmpty() || report.getHospital().trim().isEmpty()||report.getPatientName().trim().isEmpty())
                throw new NullPointerException();
		else
			report=medical_report_service.updateReport(report);
		
		
		if(report!=null)
			return report;
		else
			throw new DataNotFoundException("Data Not Available For "+p_name);
	
	}
	
	
}
