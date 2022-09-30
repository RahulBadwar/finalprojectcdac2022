package com.bookmybus.Bookmybus.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViewBusDTO {
	@NotBlank(message = "Source can not be blank")
	private String source;
	@NotBlank(message = "Destination can not be blank")
	private String destination;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;
	
	
}
