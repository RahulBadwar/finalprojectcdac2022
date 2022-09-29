package com.bookmybus.Bookmybus.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bookmybus.Bookmybus.dto.BusDTO;
import com.bookmybus.Bookmybus.dto.ErrorDTO;
import com.bookmybus.Bookmybus.dto.ScheduleDTO;
import com.bookmybus.Bookmybus.dto.ViewBusDTO;
import com.bookmybus.Bookmybus.service.Adminservice;
import com.bookmybus.Bookmybus.service.BusService;

@CrossOrigin
@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService busService;
	
	@Autowired
	private Adminservice adminservice;
	
	@PostMapping("/add-bus")
	public ResponseEntity<?> addBus(@Valid @RequestBody BusDTO busDTO,BindingResult re){
		
		System.out.println(busDTO);
		
		if(re.hasFieldErrors()) {
			System.out.println(re);
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);

		}
		
		return new ResponseEntity<>(busService.addBus(busDTO), HttpStatus.OK);
	}
	
	@GetMapping("/viwe-bus/{id}")
	public ResponseEntity<?> viweBus(@PathVariable int id){
		
		return new ResponseEntity<>(busService.viweBus(id),HttpStatus.OK);		
	}
	
	
	@PostMapping("/view-bus")
	public ResponseEntity<?> viewBus(@Valid @RequestBody ViewBusDTO vb, BindingResult br) {
		System.out.println("in view bus " + vb);
		if (br.hasFieldErrors())
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(busService.fetchBuses(vb.getSource(), vb.getDestination(), vb.getDateOfJourney()), HttpStatus.OK); //
	}
	
	
	@PostMapping("/view-bus1")
	public ResponseEntity<?> viewBus1(@RequestBody int userid) {
		
		return new ResponseEntity<>(busService.fetchBuses1(userid), HttpStatus.OK); //
	}
	
	@DeleteMapping("/delete-bus")
	public ResponseEntity<?> removeBus(@RequestParam int busid){
		
		return new ResponseEntity<>(busService.removeBus(busid),HttpStatus.OK);
	}
	
	
		
}
