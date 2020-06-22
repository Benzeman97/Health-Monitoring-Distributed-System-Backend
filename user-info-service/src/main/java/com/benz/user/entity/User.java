package com.benz.user.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.user.cfg.Schema;

@Entity
@Table(name="USERTABLE",schema=Schema.HR)
@IdClass(UserId.class)
public class User {

	@Id
	@SequenceGenerator(name="USER_ID_GEN",sequenceName="USER_ID_SEQ",initialValue=1001,allocationSize=1)
	@GeneratedValue(generator="USER_ID_GEN")
	@Column(name="USER_ID")
	private int userId;
	@Column(name="FNAME",nullable=false)
	private String fname;
	@Column(name="LNAME",nullable=false)
	private String lname;
	@Id
	@Column(name="NIC_OR_PASSPORT",nullable=false)
	private String uniqueId;
	@Column(name="DISTRICT",nullable=false)
	private String district;
	@Column(name="EMAIL",nullable=false)
	private String email;
	@Column(name="PNUM",nullable=false)
	private String pnum;
	@Column(name="U_PASSWORD",nullable=false)
	private String uPassword;
	@Column(name="CREATED_DATE",nullable=false)
	private Date created_date;
	@Column(name="MODIFIED_DATE",nullable=true)
	private Date modifiedDate;
	@Column(name="USER_TYPE",nullable=false)
	private String userType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
