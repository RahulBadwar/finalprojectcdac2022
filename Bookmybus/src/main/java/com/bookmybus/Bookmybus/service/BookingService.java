package com.bookmybus.Bookmybus.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookmybus.Bookmybus.dao.BookingDao;
import com.bookmybus.Bookmybus.dao.BusDao;
import com.bookmybus.Bookmybus.dao.RouteDao;
import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.dto.BookingDTO;
import com.bookmybus.Bookmybus.enity.Booking;
import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Route;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RouteDao routeDao;
	
	

	public Object addBooking(@Valid BookingDTO bookingDTO) {
		
		// TODO Auto-generated method stub
		
		Booking booking=new Booking();
		
		BeanUtils.copyProperties(bookingDTO, booking);
		
		try {
			
			Bus bus=busDao.findById(bookingDTO.getBusid()).orElse(null);
			
			Myuser myuser=userDao.findById(bookingDTO.getUserid()).get();
		
			booking.setRoute(bus.getRoute());
			
			booking.setUser(myuser);
			
			booking.setDateofBooking(LocalDate.now());
			
			booking.setBus(bus);
			
			bookingDao.save(booking);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Error while adding booking";
		}
		
		return "Booking added";
	}



	public List<Booking> myBookings(int userid) {
		// TODO Auto-generated method stub
		
		Myuser myuser=userDao.findById(userid).get();
		
		List<Booking> list=bookingDao.myBookings(userid);
		
		return list;
	}
	
	
	
}
