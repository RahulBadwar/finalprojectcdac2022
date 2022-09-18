package com.bookmybus.Bookmybus.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmybus.Bookmybus.dto.ChangepasswordDTO;
import com.bookmybus.Bookmybus.dto.ErrorDTO;
import com.bookmybus.Bookmybus.dto.MyuserDTO;
import com.bookmybus.Bookmybus.enity.Address;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Role;
import com.bookmybus.Bookmybus.service.MyuserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class Myusercontroller {

	@Autowired
	private MyuserService service;
	
	
	//for user signup
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@Valid @RequestBody MyuserDTO user,BindingResult re) {
    
		//System.out.println(re.hasFieldErrors());
		
		//System.out.println(re.getFieldErrorCount());
		System.out.println(user);
		
		if(re.hasFieldErrors()) {
			
			System.out.println(re);
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(service.addUser(user),HttpStatus.CREATED);
				
	}
	
	// to change user password
	
	@PutMapping("/change-password/{id}")
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangepasswordDTO pass,BindingResult re,@PathVariable int id){
		
		System.out.println(pass);
		
		if(re.hasFieldErrors()) {
			System.out.println(re);
			return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);

		}
		
		
		return new ResponseEntity<>(service.changePassword(pass,id), HttpStatus.OK) ;
		
	}
	
	//to edit profile
	
		@PostMapping("/edit-profile/{id}")
		public ResponseEntity<?> editUser(@Valid @RequestBody MyuserDTO user,@PathVariable int id,BindingResult re){
			
			System.out.println(user);
			
			if(re.hasFieldErrors()) {
				System.out.println(re);
				return new ResponseEntity<>(new ErrorDTO("Server side error", "Invalid input"), HttpStatus.BAD_REQUEST);

			}
			
			return new ResponseEntity<>(service.editUser(user,id), HttpStatus.OK) ;

			
		}
		
		// to get all user 
		@GetMapping("/see-alluser")
		public ResponseEntity<?> seeallUser(){
			
			return new ResponseEntity<>(service.seeallUser(),HttpStatus.OK);
			
		}
		
		
		//Delete Account requar
		@DeleteMapping("/delete-account/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable int id){
			
			return new ResponseEntity<>(service.deleteUser(id),HttpStatus.OK);
		}
	
}
