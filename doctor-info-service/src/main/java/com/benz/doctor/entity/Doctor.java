package com.benz.doctor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.doctor.cfgs.Schema;



@Entity
@Table(name="DOCTORTABLE",schema=Schema.HR)
@IdClass(DocId.class)
public class Doctor {

	@Id
	@SequenceGenerator(name="DOC_ID_GEN",sequenceName="DOC_ID_SEQ",initialValue=6001,allocationSize=1)
	@GeneratedValue(generator="DOC_ID_GEN")
	@Column(name="DOC_ID")
	private int docId;
	@Column(name="DOC_NAME",nullable=false)
	private String docName;
	@Column(name="SLMCREGNO",nullable=false)
	private String slmcRegNo;
	@Column(name="DISTRICT",nullable=false)
	private String district;
	@Column(name="EMAIL",nullable=false)
	private String email;
	@Column(name="PNUM",nullable=false)
	private String pnum;
	@Column(name="HOSPITAL",nullable=false)
	private String hospital;
	@Column(name="SPECIALIZATION",nullable=false)
	private String specialization;
	@Column(name="CREATED_DATE",nullable=true)
	private Date created_date;
	@Column(name="MODIFIED_DATE",nullable=true)
	private Date modifiedDate;
	
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getSlmcRegNo() {
		return slmcRegNo;
	}
	public void setSlmcRegNo(String slmcRegNo) {
		this.slmcRegNo = slmcRegNo;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
