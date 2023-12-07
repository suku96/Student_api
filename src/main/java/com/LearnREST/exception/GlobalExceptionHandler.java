package com.LearnREST.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorRespose> handleResourceNotFoundException(ResourceNotFoundException ex) {
		   ErrorRespose errorResponse = new ErrorRespose(ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	
}
