package com.bookmybus.Bookmybus.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusDTO {

	private int userid;
	
	@NotBlank(message = "Bus number cannot be blank")
    private String busNumber;
	
	//@NotBlank(message = "Total seat cannot be blank")
	private int totalSeats;
	
	
	
	
	@NotBlank
	private String busName;
	
	
	//@NotEmpty(message = "bus fare should not empty")
	private double busFare;
	
	

	

	

	

	
	

	

	

	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}

	
	
	
}
