package com.part.microservice.partservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	protected ResponseEntity<Object> handleUserNotFoundException(PartNotFoundException ex, HttpHeaders headers, HttpStatusCode status,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
