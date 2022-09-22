package com.bookmybus.Bookmybus.dto;

import javax.validation.constraints.NotBlank;

public class RouteDTO {

	private int routeid;

	@NotBlank(message = "Source can not be blank")
	private String source;
	
	@NotBlank(message = "Destination can not be blank")
	private String destination;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "RouteDTO [source=" + source + ", destination=" + destination + "]";
	}

	public int getRouteid() {
		return routeid;
	}

	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	
	
	
	
}
