package com.bookmybus.Bookmybus.enity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;
	
	
	private PaymentStatus status;
	
	private double fareAmount;
	
	private LocalDate dateoftransaction;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private Myuser user;
	@OneToOne
	@JoinColumn(name = "bookingid")
	private Booking booking;
	
	
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public double getFareAmount() {
		return fareAmount;
	}
	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}
	public LocalDate getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(LocalDate dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public Myuser getUser() {
		return user;
	}
	public void setUser(Myuser user) {
		this.user = user;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	
	
	
	
}
