package com.bookmybus.Bookmybus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.Route;

public interface RouteDao extends JpaRepository<Route,Integer> {

	public Optional<Route> findBySourceAndDestination(String source, String destination);

	
}
