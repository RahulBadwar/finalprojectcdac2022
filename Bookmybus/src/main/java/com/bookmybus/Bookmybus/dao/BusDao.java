package com.bookmybus.Bookmybus.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmybus.Bookmybus.enity.Bus;
import com.bookmybus.Bookmybus.enity.BusSchedule;
import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Route;

@Repository
public interface BusDao extends JpaRepository<Bus,Integer>{


	@Query("select b from Bus b where b.user.userid =:id")
	List<Bus> findByMyuser(@Param("id") int userid);

	
	//List<Bus> findByUserid(int userid);

	

}
