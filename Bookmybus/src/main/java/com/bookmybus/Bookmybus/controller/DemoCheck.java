package com.bookmybus.Bookmybus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCheck {

	@RequestMapping("/home1")
	public String demo() {
		
		return "in demo";
	}
}
