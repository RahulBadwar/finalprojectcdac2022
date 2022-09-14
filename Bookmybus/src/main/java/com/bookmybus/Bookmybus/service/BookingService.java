package com.bookmybus.Bookmybus.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmybus.Bookmybus.dao.BookingDao;
import com.bookmybus.Bookmybus.dao.BusDao;
import com.bookmybus.Bookmybus.dto.BookingDTO;
import com.bookmybus.Bookmybus.enity.Booking;
import com.bookmybus.Bookmybus.enity.Bus;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	
	@Autowired
	private BusDao busDao;
	
	

	public Object addBooking(@Valid BookingDTO bookingDTO) {
		
		// TODO Auto-generated method stub
		
		Booking booking=new Booking();
		
		BeanUtils.copyProperties(bookingDTO, booking);
		
		try {
			
			Bus bus=busDao.findById(bookingDTO.getBusid()).orElse(null);
			
		
			
			booking.setBus(bus);
			
			bookingDao.save(booking);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Error while adding booking";
		}
		
		return "Booking added";
	}
	
	
	
}
