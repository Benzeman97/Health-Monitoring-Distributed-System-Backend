package com.benz.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.benz.user.cfg.Schema;

@Entity
@Table(name="MEMBERTABLE",schema=Schema.HR)
public class Member {

	@Id
	@Column(name="MID")
	@SequenceGenerator(name="MID_GEN",sequenceName="MID_SEQ",initialValue=6001,allocationSize=1)
	@GeneratedValue(generator = "MID_GEN")
	private int mId;
	@Column(name="FNAME")
	private String fname;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="DISTRICT")
	private String district;
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
}
