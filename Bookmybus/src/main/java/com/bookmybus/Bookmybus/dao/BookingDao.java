package com.bookmybus.Bookmybus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmybus.Bookmybus.enity.Booking;


@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

}
