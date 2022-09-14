package com.bookmybus.Bookmybus.dto;

import java.time.LocalDateTime;

public class ErrorDTO {

	private String message;
	private LocalDateTime timeStamp;
	private String errDetails;

	public ErrorDTO(String message, String errDetails) {
		super();
		this.message = message;
		this.errDetails = errDetails;
		this.timeStamp = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrDetails() {
		return errDetails;
	}

	public void setErrDetails(String errDetails) {
		this.errDetails = errDetails;
	}
	
	
	
	
}
