package com.bookmybus.Bookmybus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.enity.Address;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Role;
import com.bookmybus.Bookmybus.service.MyuserService;

@SpringBootApplication
public class BookmybusApplication implements CommandLineRunner {

	//@Autowired
	//private PasswordEncoder encoder;
	
	//@Autowired
	//private static MyuserService service;
	
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		
		SpringApplication.run(BookmybusApplication.class, args);
		
		
	}
	
	
	


	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
