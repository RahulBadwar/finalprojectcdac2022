package com.bookmybus.Bookmybus.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.dto.BusDTO;
import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.BusSchedule;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Route;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private BusScheduleDao busScheduleDao;
	
	public String addBus(@Valid BusDTO busDTO) {
		// TODO Auto-generated method stub
		Bus bus=new Bus();
		
		BeanUtils.copyProperties(busDTO, bus);
		
		Myuser myuser=userDao.getById(busDTO.getUserid());
		//bus.setTotalSeats(0);
		bus.setBookedSeat(0);
		bus.setUser(myuser);
		
		System.out.println(bus);
		try {
			busDao.save(bus);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error while adding bus";
		}
		
		return "Bus added successfully";
	}

	public Bus viweBus(int id) {
		// TODO Auto-generated method stub
		Bus bus;
		
		try {
		bus=busDao.findById(id).get();
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		return bus;
	}

	public List<BusSchedule> fetchBuses(String source, String destination, LocalDate dateOfJourney){    //) {
		Route route = routeDao.findBySourceAndDestination(source, destination).get();
		List<BusSchedule> busSchedules = busScheduleDao.findByRoute(route);
		List<BusSchedule> response = new ArrayList<>();
		for (BusSchedule busSchedule : busSchedules) {
			LocalDateTime m=busSchedule.getDepttime();
			
			LocalDate n=m.toLocalDate();
			
			System.out.println("m is "+m);
			
			System.out.println("n is "+n);
			
			System.out.println(busSchedule);
			
			if(n.equals(dateOfJourney))
				response.add(busSchedule); 
		}
		return response;
	}

	
}
