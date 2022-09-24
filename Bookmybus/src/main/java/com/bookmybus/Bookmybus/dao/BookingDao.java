package com.bookmybus.Bookmybus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmybus.Bookmybus.enity.Booking;


@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
	@Query("select b from Booking b where b.user.userid =:id")
	public List<Booking> myBookings(@Param("id") int userid);
}
