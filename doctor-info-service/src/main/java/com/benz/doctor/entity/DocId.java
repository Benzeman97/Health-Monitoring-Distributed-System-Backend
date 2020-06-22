package com.benz.doctor.entity;

import java.io.Serializable;

public class DocId implements Serializable{

	private static final long serialVersionUID = 4204634452589680444L;
	
	private int docId;
	private String slmcRegNo;

	public DocId() {
	}
	public DocId(int docId, String slmcRegNo) {
		this.docId = docId;
		this.slmcRegNo = slmcRegNo;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getSlmcRegNo() {
		return slmcRegNo;
	}
	public void setSlmcRegNo(String slmcRegNo) {
		this.slmcRegNo = slmcRegNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + docId;
		result = prime * result + ((slmcRegNo == null) ? 0 : slmcRegNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocId other = (DocId) obj;
		if (docId != other.docId)
			return false;
		if (slmcRegNo == null) {
			if (other.slmcRegNo != null)
				return false;
		} else if (!slmcRegNo.equals(other.slmcRegNo))
			return false;
		return true;
	}
	
	

	
}
