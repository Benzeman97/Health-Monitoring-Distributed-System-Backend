package com.benz.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.benz.common.model.ErrorMessage;

@RestControllerAdvice
public class DataNotFoundExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> response(DataNotFoundException ex)
	{
		ErrorMessage errorMessage=new ErrorMessage(404,ex.getMessage(),"www.benz_nsbm.com");
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
