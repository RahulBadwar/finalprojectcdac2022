package com.bookmybus.Bookmybus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmybus.Bookmybus.dao.BookingDao;
import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.dto.BookingDTO;
import com.bookmybus.Bookmybus.dto.ErrorDTO;
import com.bookmybus.Bookmybus.enity.Booking;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private BookingDao bookingdao;
	
	
	@Autowired
	private BookingService bookingService;
	
	
	
	
	@PostMapping("/add-booking")
	public ResponseEntity<?> addBooking(@Valid @RequestBody BookingDTO bookingDTO,BindingResult re) {
		
		System.out.println(bookingDTO);
		
		if(re.hasFieldErrors()) {
			System.out.println(re);
			return new ResponseEntity<>(new ErrorDTO("Server side error","Invalid input"),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(bookingService.addBooking(bookingDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("my-bookings/{userid}")
	public ResponseEntity<?> myBookings(@PathVariable int userid ){
		
		return new ResponseEntity<>(bookingService.myBookings(userid),HttpStatus.OK);
	}
	
	//@PostMapping("/view-bookings-owner")
	//public ResponseEntity<?> vivwBooking(@RequestParam int busId){
		
		//return  new ResponseEntity<T>(null, null)
	//}
	
}
