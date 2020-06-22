package com.benz.doctor.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2491065979792776613L;
	
	public DataNotFoundException(String msg)
	{
		super(msg);
	}

}
