package com.bookmybus.Bookmybus.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<RouteDTO> getRoutes() {
		// TODO Auto-generated method stub
		List<Route> list=routeDao.findAll();
		
		List<RouteDTO> list1=new ArrayList<>();
		
		RouteDTO dto=null;
		
		for(Route route:list) {
			dto=new RouteDTO();
			BeanUtils.copyProperties(route, dto);
			list1.add(dto);
		}
		
		return list1;
	}
	
	
	
}
