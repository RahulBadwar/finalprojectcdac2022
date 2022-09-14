package com.bookmybus.Bookmybus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmybus.Bookmybus.enity.BusSchedule;

public interface BusScheduleDao extends JpaRepository<BusSchedule,Integer> {

}
