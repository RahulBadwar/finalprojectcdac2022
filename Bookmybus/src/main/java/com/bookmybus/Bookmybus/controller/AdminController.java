package com.bookmybus.Bookmybus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmybus.Bookmybus.dto.ErrorDTO;
import com.bookmybus.Bookmybus.dto.ScheduleDTO;
import com.bookmybus.Bookmybus.service.Adminservice;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private Adminservice adminservice;
	
	@PostMapping("/add-schedule")
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleDTO scheduleDTO,BindingResult re){
		
		System.out.println(scheduleDTO);
		
		System.out.println("in the controller");
		
		if(re.hasFieldErrors()) {
			System.out.println(re);
			
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);

		}
		
		return new ResponseEntity<>(adminservice.addSchedule(scheduleDTO), HttpStatus.CREATED);
		
	}
	
}
