package com.bookmybus.Bookmybus.enity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class BusSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivaltime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate depttime;
	
	@OneToOne
	@JoinColumn(name = "routeid")
	private Route route;
	
	
	@OneToOne
	@JoinColumn(name = "busid")
	private Bus bus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
	
}
