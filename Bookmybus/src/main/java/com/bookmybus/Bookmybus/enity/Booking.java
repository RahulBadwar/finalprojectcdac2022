package com.bookmybus.Bookmybus.enity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	
	private int seatNumber;
	
	private LocalDate dateofJourny;
	
	private LocalDate dateofBooking;
	
	private double fareAmount;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingstatus;
	
	@ManyToOne
	@JoinColumn(name = "busid")
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name = "routeid")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Myuser user;
	
	
	
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	

	

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getFareAmount() {
		return fareAmount;
	}

	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}

	public BookingStatus getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(BookingStatus bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDate getDateofJourny() {
		return dateofJourny;
	}

	public void setDateofJourny(LocalDate dateofJourny) {
		this.dateofJourny = dateofJourny;
	}

	public LocalDate getDateofBooking() {
		return dateofBooking;
	}

	public void setDateofBooking(LocalDate dateofBooking) {
		this.dateofBooking = dateofBooking;
	}

	public Myuser getUser() {
		return user;
	}

	public void setUser(Myuser user) {
		this.user = user;
	}
	
	
	
	
	
}
