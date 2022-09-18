/*package com.bookmybus.Bookmybus.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.enity.Myuser;

@Component
public class CustomUserdetails implements UserDetailsService {

	@Autowired
	private UserDao userDao;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Myuser myuser=userDao.findByEmail(username);
		
		System.out.println(myuser+"in websecurity");
		
		System.out.println("in web security");
		
		myuser=userDao.findById(1).get();
		
		System.out.println(myuser+"in websecurity");
		
		//return myuser;
		return new org.springframework.security.core.userdetails.User(myuser.getEmail(),  myuser.getPassword(),
				new ArrayList<>());
	}

	
}*/
