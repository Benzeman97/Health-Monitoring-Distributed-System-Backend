package com.benz.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Planning")
public class Planing {

	public List<Keto> ketos;
	

	public Planing() {
	}

	public Planing(List<Keto> ketos) {
		this.ketos = ketos;
	}

	public List<Keto> getKetos() {
		return ketos;
	}

	public void setKetos(List<Keto> ketos) {
		this.ketos = ketos;
	}
	
	
}
