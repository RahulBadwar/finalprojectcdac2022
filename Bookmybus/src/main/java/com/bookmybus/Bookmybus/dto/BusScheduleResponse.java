package com.bookmybus.Bookmybus.dto;

import java.util.List;

import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.Route;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BusScheduleResponse {
	public BusScheduleResponse(List<Bus> buses2, List<Route> routes2) {
		// TODO Auto-generated constructor stub
		this.buses=buses2;
		this.routes=routes2;
	}
	private List<Bus> buses;
	private List<Route> routes;
}
