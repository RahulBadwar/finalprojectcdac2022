package com.bookmybus.Bookmybus.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	
	@Autowired
    private EmailSenderService emailSenderService;
	
	

	public Object addBooking(@Valid BookingDTO bookingDTO) {
		
		// TODO Auto-generated method stub
		
		Booking booking=new Booking();
		
		BeanUtils.copyProperties(bookingDTO, booking);
		
		try {
			
			Bus bus=busDao.findById(bookingDTO.getBusid()).orElse(null);
			
			bus.setBookedSeat(bus.getBookedSeat()+1);
			
			busDao.save(bus);
			
			Myuser myuser=userDao.findById(bookingDTO.getUserid()).get();
		
			booking.setRoute(bus.getRoute());
			
			booking.setFareAmount(bus.getBusFare());
			
			booking.setUser(myuser);
			
			booking.setDateofBooking(LocalDate.now());
			
			booking.setBus(bus);
			
			System.out.println(booking.getFareAmount());
			
			String mess="Email-"+myuser.getEmail()
			+"\n" +
			"\n"+"Gender-"+myuser.getGender()+"\n"+"\n"+
			"Mobile--"+myuser.getMobile()
			+"Bus Name--"+bus.getBusName()+"\n"+
			"From--"+bus.getRoute().getSource()+"\n"+
			"To--"+bus.getRoute().getDestination()+
			"\n"+"Date of journy-"+bookingDTO.getDateofJourny();
			
			emailSenderService.sendEmail(mess, "Booking Information", myuser.getEmail(), "bookmybuscdac@gmail.com");
			
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



	public List<Booking> allBookings() {
		// TODO Auto-generated method stub
		List<Booking> list=bookingDao.findAll();
		return list;
	}



	public List<Booking> ownerBookings(int userid) {
		// TODO Auto-generated method stub
		
		Myuser myuser=userDao.findById(userid).get();
		
		List<Booking> re=new ArrayList<>();
		
		List<Bus> b=busDao.findByMyuser(myuser.getUserid());
		
		for (Bus bus : b) {
			
			List<Booking> b1=bookingDao.FindByBus(bus.getBusid());
			re.addAll(b1);
		}
		
		return re;
	}
	
	
	
}
