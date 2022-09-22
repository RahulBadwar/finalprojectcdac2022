package com.bookmybus.Bookmybus.dto;

import com.bookmybus.Bookmybus.enity.Myuser;
import com.bookmybus.Bookmybus.enity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResp {
	private String message;
	private String jwt;
	
	
	public AuthResp(String message, String jwt) {
		super();
		this.message = message;
		this.jwt = jwt;
	}

	//private Role role;
	
	//private int userid;
	
	private Myuser user;
	
}
