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
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookmybus.Bookmybus.dao.AddressDao;
import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.dto.ChangepasswordDTO;
import com.bookmybus.Bookmybus.dto.MyuserDTO;
import com.bookmybus.Bookmybus.enity.Address;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.exception.AdduserExpection;



@Service
public class MyuserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private AddressDao addressDao;
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	
	public String addUser(@Valid
			MyuserDTO user) {
		
		try {
		Myuser myuser=new Myuser();
		
		
		
		//beanutils to object mapping
		//model mapppers
		BeanUtils.copyProperties(user,myuser);
		
		//myuser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Address address=new Address();
		BeanUtils.copyProperties(user, address);
		
		myuser.setAddress(address);
		
		address.setUser(myuser);
		
		
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
		
		Address address=myuser.getAddress();
		
		BeanUtils.copyProperties(user, address);
		
		BeanUtils.copyProperties(user, myuser);
		myuser.setAddress(address);
		
		
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
			BeanUtils.copyProperties(myuser.getAddress(),myuserDTO);
			
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
	

	
	

	
	
	
	
}
