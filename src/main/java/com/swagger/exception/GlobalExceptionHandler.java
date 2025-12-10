package com.swagger.exception;


import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleInputException(EmptyInputException emptyInputException) {
		
		return new ResponseEntity<String>("Input fields are empty, Please look into it", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		
		return new ResponseEntity<String>("No value is presnt in DB, Please change your request", HttpStatus.NOT_FOUND);
	}
	
}
