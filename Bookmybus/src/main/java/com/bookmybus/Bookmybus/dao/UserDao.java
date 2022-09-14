package com.bookmybus.Bookmybus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookmybus.Bookmybus.enity.Myuser;

@Repository
public interface UserDao extends JpaRepository<Myuser, Integer> {

	//@Query()
	//public Optional<Myuser> findbyEmail(String email);
	
	//@Query(
			  //value = "SELECT * FROM myusers u WHERE u.email = ?1", 
			  //nativeQuery = true)
	public Myuser findByEmail(String email);
}
