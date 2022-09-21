package com.bookmybus.Bookmybus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookmybus.Bookmybus.dao.UserDao;
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
	
	
	public void adduser() {
		
		//String l=encoder.encode("rahul500@@");
		
		//System.out.println(l);
		
		//System.out.println(encoder.matches("rahul500@@", "$2a$10$NX8eyKY7N49GxwOplY7PVO5AwiaZKr4AQpwP2R7UtkpqGFwknSC0G"));
		
		
	}


	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//String l=encoder.encode("rahul500@@");
		
		//System.out.println(l);
		
		//System.out.println(encoder.matches("rahul500@@", "$2a$10$NX8eyKY7N49GxwOplY7PVO5AwiaZKr4AQpwP2R7UtkpqGFwknSC0G"));
		
		//Myuser myuser=userDao.findByEmail("rahul51400h@gmail.com");
		
		//System.out.println(myuser);
	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
