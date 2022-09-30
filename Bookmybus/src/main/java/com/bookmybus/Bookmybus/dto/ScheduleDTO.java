package com.bookmybus.Bookmybus.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScheduleDTO {

@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
private LocalDateTime depttime;
	
	
	private int busid;
	
	private int routeid;
}
