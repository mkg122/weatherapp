package com.weatherapp.config.exception;

import java.util.Date;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling implements ErrorController {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customException(CustomException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),ex.getHttpStatus().value(), new Date());
	    return new ResponseEntity<ErrorResponse>(errorResponse, ex.getHttpStatus());
	}
	
}