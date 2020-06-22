package com.benz.report.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.report.cfg.Schema;

@Entity
@Table(name="REPORTTABLE",schema=Schema.HR)
public class Report {

	@Id
	@SequenceGenerator(name = "REPORT_ID_GEN",sequenceName = "REPORT_ID_SEQ",initialValue = 8001,allocationSize = 1)
	@GeneratedValue(generator = "REPORT_ID_GEN")
	@Column(name="REPORT_ID")
	private int reportId;
	@Column(name="REPORT_TYPE",nullable=false)
	private String reportType;
	@Column(name="REPORT_DATE")
	private Date reportDate;
	@Column(name="HOSPITAL")
	private String hospital;
	@Column(name="PATIENTNAME")
	private String patientName;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	
}
