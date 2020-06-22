package com.benz.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.benz.user.model.ErrorMessage;

@RestControllerAdvice
public class DataNotFoundExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> toResponse(DataNotFoundException ex)
	{
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),404,"www.benz.com");
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
