package com.benz.common.exception;

public class DataNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 4928287994512459444L;

	public DataNotFoundException(String msg)
	{
		super(msg);
	}
}
