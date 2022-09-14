package com.bookmybus.Bookmybus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmybus.Bookmybus.dto.ErrorDTO;
import com.bookmybus.Bookmybus.dto.RouteDTO;
import com.bookmybus.Bookmybus.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

	
	@Autowired
	private RouteService routeService;
	
	@PostMapping("/add-route")
	public ResponseEntity<?> addRoute(@Valid @RequestBody RouteDTO routeDTO,BindingResult re) {
		System.out.println(routeDTO);
		
		if(re.hasFieldErrors()) {
			System.out.println(re);
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(routeService.addRoute(routeDTO), HttpStatus.CREATED);
	}
	
	
}
