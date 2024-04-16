package com.weatherapp.config.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ErrorResponse {

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date timestamp;
	private String error;
	private Integer status;

	public ErrorResponse(String message, Integer status, Date timestamp) {
		this.timestamp = timestamp;
	    this.error = message;
	    this.status = status;
	}

}
