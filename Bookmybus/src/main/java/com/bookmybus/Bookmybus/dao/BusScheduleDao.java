package com.bookmybus.Bookmybus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmybus.Bookmybus.enity.BusSchedule;
import com.bookmybus.Bookmybus.enity.Route;

public interface BusScheduleDao extends JpaRepository<BusSchedule,Integer> {

	List<BusSchedule> findByRoute(Route route);

}
