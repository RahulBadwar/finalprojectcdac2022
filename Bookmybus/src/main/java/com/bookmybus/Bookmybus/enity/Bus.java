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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table
@Getter
@Setter
@ToString
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busid;
	
	private String busNumber;
	
	private int totalSeats;
	
	
	private int bookedSeat;
	
	private String busName;
	
	private String busType;
	
	private double busFare;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "routeid")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Myuser user;

	
	
	

	
	
	
	
	
	
	
}
