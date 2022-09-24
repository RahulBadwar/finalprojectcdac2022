package com.bookmybus.Bookmybus.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.bookmybus.Bookmybus.dao.BusDao;
import com.bookmybus.Bookmybus.dao.BusScheduleDao;
import com.bookmybus.Bookmybus.dao.RouteDao;
import com.bookmybus.Bookmybus.dto.BusScheduleResponse;
import com.bookmybus.Bookmybus.dto.ScheduleDTO;
import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.BusSchedule;
import com.bookmybus.Bookmybus.enity.Route;

@Service
public class Adminservice {

	@Autowired
	private BusScheduleDao busScheduleDao;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private RouteDao routeDao;
	
	public String addSchedule(@Valid ScheduleDTO scheduleDTO) {
		// TODO Auto-generated method stub
		
		BusSchedule busSchedule=new BusSchedule();
		
		BeanUtils.copyProperties(scheduleDTO, busSchedule);
		
		try {
			Bus bus=busDao.findById(scheduleDTO.getBusid()).get();
			
			int a=scheduleDTO.getBusid();
			
			System.out.println(busSchedule.toString());
			Route route=routeDao.findById(scheduleDTO.getRouteid()).get();
			
			bus.setRoute(route);
			busSchedule.setBus(bus);
			
			
			busSchedule.setRoute(route);
			
			 busScheduleDao.save(busSchedule);
			 
			 return "Bus schedule added";
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			return "Fail to addschedule";
			}
		
	}

	
	public BusScheduleResponse getScheduleDetails() {
		List<Bus> buses = new ArrayList<>();
		List<Route> routes = new ArrayList<>();
		buses = busDao.findAll();
		routes = routeDao.findAll();
		return new BusScheduleResponse(buses, routes);
	}


}
