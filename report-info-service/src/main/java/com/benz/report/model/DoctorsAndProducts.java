package com.benz.report.model;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "DoctorsAndProducts")
public class DoctorsAndProducts {

	
	private String docName;
	private String slmcRegNo;
	private String district;
	private String pnum;
	private String hospital;
	private String specialization;
	private int productId;
	private String productName;
	private String madeBy;
	private double price;
	private String category;
	private String info;
	
	
	public DoctorsAndProducts() {
	}
	
	public DoctorsAndProducts(String docName, String slmcRegNo, String district, String pnum, String hospital,
			String specialization, int productId, String productName, String madeBy, double price, String category,
			String info) {
		this.docName = docName;
		this.slmcRegNo = slmcRegNo;
		this.district = district;
		this.pnum = pnum;
		this.hospital = hospital;
		this.specialization = specialization;
		this.productId = productId;
		this.productName = productName;
		this.madeBy = madeBy;
		this.price = price;
		this.category = category;
		this.info = info;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	
	
	
}
