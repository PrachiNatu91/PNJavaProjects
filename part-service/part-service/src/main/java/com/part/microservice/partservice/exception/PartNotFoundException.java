package com.part.microservice.partservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PartNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {	
		return "User was not found";
	}

}
