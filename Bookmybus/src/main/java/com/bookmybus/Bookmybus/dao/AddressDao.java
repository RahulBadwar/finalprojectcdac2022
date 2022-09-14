package com.bookmybus.Bookmybus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmybus.Bookmybus.enity.Address;


@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {

}
