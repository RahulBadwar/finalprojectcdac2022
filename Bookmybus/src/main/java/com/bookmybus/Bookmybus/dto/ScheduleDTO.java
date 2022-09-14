package com.bookmybus.Bookmybus.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivaltime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate depttime;
	
	
	private int busid;
	
	private int routeid;

	public LocalDate getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(LocalDate arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public LocalDate getDepttime() {
		return depttime;
	}

	public void setDepttime(LocalDate depttime) {
		this.depttime = depttime;
	}

	public int getBusid() {
		return busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	public int getRouteid() {
		return routeid;
	}

	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	
	
}
