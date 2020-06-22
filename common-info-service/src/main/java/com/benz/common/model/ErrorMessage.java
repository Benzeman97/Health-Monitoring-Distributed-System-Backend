package com.benz.common.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ErrorMessage")
public class ErrorMessage {

	private int errorCode;
	private String errorMsg;
	private String documentation;

	public ErrorMessage() {
	}
	public ErrorMessage(int errorCode, String errorMsg, String documentation) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.documentation = documentation;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
