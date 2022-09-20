package com.bookmybus.Bookmybus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookmybus.Bookmybus.dao.UserDao;
import com.bookmybus.Bookmybus.enity.Myuser;

import lombok.ToString;

@Service // or @Component also works!
@Transactional

public class MyUserDetailsService implements UserDetailsService {
	// dep : user repository : based upon spring data JPA
	@Autowired
	private UserDao userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in load by user nm " + username);
		// invoke dao's method to load user details from db by username(ie. actaully an
		// email)
		Myuser user = userRepo.
				findByEmail(username).
				orElseThrow(() -> new UsernameNotFoundException("Invalid Email ID "));
		System.out.println("lifted user dtls from db "+user);
		return new CustomUserDetails(user);
	}

}
