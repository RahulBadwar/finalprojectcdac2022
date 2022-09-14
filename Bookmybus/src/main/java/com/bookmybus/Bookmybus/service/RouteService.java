package com.bookmybus.Bookmybus.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmybus.Bookmybus.dao.RouteDao;
import com.bookmybus.Bookmybus.dto.RouteDTO;
import com.bookmybus.Bookmybus.enity.Route;

@Service
public class RouteService {

	@Autowired
	private RouteDao routeDao;

	public Object addRoute(@Valid RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		
		Route route=new Route();
		
		BeanUtils.copyProperties(routeDTO, route);
		
		try {
			return routeDao.save(route);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return "Failed to add";
		}
		
		
	}
	
	
	
}
