package com.bookmybus.Bookmybus.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class BusDTO {

	@NotBlank(message = "Bus number cannot be blank")
    private String busno;
	
	//@NotBlank(message = "Total seat cannot be blank")
	private int totalseat;
	
	
	private int bookedseat=0;
	
	@NotBlank
	private String busname;
	
	
	//@NotEmpty(message = "bus fare should not empty")
	private int busFare;
	
	

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

	public int getBusFare() {
		return busFare;
	}

	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}

	@Override
	public String toString() {
		return "BusDTO [busno=" + busno + ", totalseat=" + totalseat + ", bookedseat=" + bookedseat + ", busname="
				+ busname + ", busFare=" + busFare + "]";
	}
	
	
}
