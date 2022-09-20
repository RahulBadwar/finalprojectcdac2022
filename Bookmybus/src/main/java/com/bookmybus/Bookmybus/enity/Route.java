package com.bookmybus.Bookmybus.enity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Setter;



@Entity
@Table
public class Route {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int routeid;
	
	private String source;
	
	private String destination;
	
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private List<Bus> buses=new ArrayList<>();
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private List<Booking> bookings=new ArrayList<>();

	public int getRouteid() {
		return routeid;
	}

	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}

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

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
	
	
}
