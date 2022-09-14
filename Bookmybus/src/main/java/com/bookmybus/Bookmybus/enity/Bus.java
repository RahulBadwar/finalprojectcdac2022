package com.bookmybus.Bookmybus.enity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busid;
	
	private String busno;
	
	private int totalseat;
	
	
	private int bookedseat;
	
	private String busname;
	
	private int busFare;
	
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "routeid")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Myuser user;

	
	
	

	public int getBusid() {
		return busid;
	}

	public int getBusFare() {
		return busFare;
	}

	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	public Myuser getUser() {
		return user;
	}

	public void setUser(Myuser user) {
		this.user = user;
	}

	public String getBusno() {
		return busno;
	}

	public void setBusno(String busno) {
		this.busno = busno;
	}

	public int getTotalseat() {
		return totalseat;
	}

	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}

	public int getBookedseat() {
		return bookedseat;
	}

	public void setBookedseat(int bookedseat) {
		this.bookedseat = bookedseat;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus [busid=" + busid + ", busno=" + busno + ", totalseat=" + totalseat + ", bookedseat=" + bookedseat
				+ ", busname=" + busname + ", busFare=" + busFare + ", bookings=" + bookings + ", route=" + route
				+ ", user=" + user + "]";
	}
	
	
	
	
	
	
	
}
