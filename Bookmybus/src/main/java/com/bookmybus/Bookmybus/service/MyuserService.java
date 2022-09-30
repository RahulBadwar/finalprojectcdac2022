package com.bookmybus.Bookmybus.service;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.dto.ChangepasswordDTO;
import com.bookmybus.Bookmybus.dto.LoginDTO;
import com.bookmybus.Bookmybus.dto.MyuserDTO;

import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.exception.AdduserExpection;
import com.bookmybus.Bookmybus.exception.UserNotFoundException;



@Service
public class MyuserService {

	@Autowired
	private UserDao dao;
	
	
	
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Autowired
    private EmailSenderService emailSenderService;
	
	
	public String addUser(@Valid
			MyuserDTO user) {
		
		try {
		Myuser myuser=new Myuser();
		
		
		
		//beanutils to object mapping
		//model mapppers
		BeanUtils.copyProperties(user,myuser);
		
		//myuser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//Address address=new Address();
		//BeanUtils.copyProperties(user, address);
		
		//myuser.setAddress(address);
		
		//address.setUser(myuser);
		
		myuser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		String mess="Email-"+user.getEmail()
		+"\n" +"Password-"+user.getPassword()+
		"\n"+"Gender-"+user.getGender()+"\n"+
		"Role-"+user.getRole()+"\n"+
		"Mobile--"+user.getMobile();
		//emailSenderService.
		
		emailSenderService.sendEmail(mess,"Registration successfull on bookmybus", user.getEmail(), "bookmybuscdac@gmail.com");
		
		dao.save(myuser);
		
		return "User Added Succesfully";	
		}
		catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			e.printStackTrace();
			return e.getMessage();
			//throw new AdduserExpection("Excetion in adding user");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new AdduserExpection("Excetion in adding user");

		}
	}

	public String changePassword(@Valid ChangepasswordDTO pass, int id) {
		// TODO Auto-generated method stub
		
		Myuser user=dao.findById(id).get();
		
		if(user.getPassword().equals(pass.getOldpassword())) {
			user.setPassword(pass.getNewpassword());
			
			dao.save(user);
			return "Chnage successfull";
		}
		
		else {
			return "Invalid Creditials";
		}
		
		
	}

	public String editUser(@Valid MyuserDTO user, int id) {
		// TODO Auto-generated method stub
		
		try {
		Myuser myuser=dao.findById(id).get();
		
		
		
		
		
		BeanUtils.copyProperties(user, myuser);
		
		
		
	dao.save(myuser);
		
		return "updated succesfully";
		
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error while updating";
		}
	}

	public List<MyuserDTO> seeallUser() {
		// TODO Auto-generated method stub
		
		//dao.findAll()
		
		List<Myuser> list=dao.findAll();
		
		List<MyuserDTO> mylist=new ArrayList<>();
		
		for (Myuser myuser : list) {
			MyuserDTO myuserDTO=new MyuserDTO();
			
			BeanUtils.copyProperties(myuser, myuserDTO);
			//BeanUtils.copyProperties(myuser.getAddress(),myuserDTO);
			
			mylist.add(myuserDTO);
			
		}
	
		
		//BeanUtils.copyProperties(list, mylist);
		System.out.println(mylist);
		return mylist;
	}

	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		
		
		try {
		dao.deleteById(id);
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "No user with such id";
		}
		return "User deleted successfully";
	}

	public MyuserDTO authenticateUser(@Valid LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		Myuser myuser=null;
		
		
			 myuser=dao.findByEmail(loginDTO.getEmail()).get();
			
			if(myuser==null)
				throw new UserNotFoundException("inavalid creadianls");
			
			boolean match=loginDTO.getPassword().equals(myuser.getPassword());
			if(!match)
				throw new UserNotFoundException("inavalid creadianls");
			
			System.out.println(myuser);
			System.out.println(match);
			
			MyuserDTO myuserDTO=new MyuserDTO();
			BeanUtils.copyProperties(myuser, myuserDTO);
		
			// TODO: handle exception
			
		//	new UserNotFoundException("inavalid creadianls");
			//return new ResponseEntity<T>(new UserNotFoundException("inavalid creadianls"), null)
		
		
		return myuserDTO;
	}
	

	
	

	
	
	
	
}
