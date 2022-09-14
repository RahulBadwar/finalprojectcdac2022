package com.bookmybus.Bookmybus.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.bookmybus.Bookmybus.enity.Gender;
import com.bookmybus.Bookmybus.enity.Role;

public class MyuserDTO {

	@NotBlank(message = "Name cannot be blank")
    private String username;
	
	@NotBlank(message = "Email is required")
	@Length(min = 5,max = 40,message = "Invalid Email length")
	@Email(message = "Invalid email format")
	private String email;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password!")
	private String password;
	
	
	@Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$", message = "Invalid mobile number")
	private String mobile;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@NotBlank(message = "street cannot be blank")
	private String street;
	
	@NotBlank(message = "city cannot be blank")
	private String city;
	
	@NotBlank(message = "state cannot be blank")
	private String state;
	
	@NotBlank(message = "pincode cannot be blank")
	private String pincode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "MyuserDTO [username=" + username + ", email=" + email + ", password=" + password + ", mobile=" + mobile
				+ ", gender=" + gender + ", dob=" + dob + ", role=" + role + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
}
