package com.benz.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.benz.hospital.cfg.Schema;

@Entity
@Table(name="HOSPITALTABLE",schema=Schema.HR)
public class Hospital {

	@Id
	@Column(name="HOSPITAL_NAME")
	private String hospitalName;
	@Column(name="DISTRICT",nullable=false)
	private String district;
	@Column(name="HOSPITAL_TYPE",nullable=false)
	private String hospitalType;
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}
	
	
	
	
}
