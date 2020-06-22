package com.benz.report.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "DoctorSpecialization")
public class DoctorSpecialization {


	private List<Doctor> doctors;

	public DoctorSpecialization() {
	}
	public DoctorSpecialization(String id, List<Doctor> doctors) {
		
		this.doctors = doctors;
	}
	
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}
