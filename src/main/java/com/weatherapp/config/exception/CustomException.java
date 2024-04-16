package com.weatherapp.config.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class CustomException extends RuntimeException{
	private static final long serialVersionUid = 1L;
	
	private HttpStatus httpStatus;
	
	public CustomException(String msg, HttpStatus httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
	}

}
