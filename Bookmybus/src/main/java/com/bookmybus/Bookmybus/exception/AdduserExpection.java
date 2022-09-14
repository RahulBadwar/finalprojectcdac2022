package com.bookmybus.Bookmybus.exception;

public class AdduserExpection extends RuntimeException {

	public AdduserExpection(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		
		System.out.println(message);
	}

	
}
