package com.bookmybus.Bookmybus.enity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
public class Myuser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	private String username;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	@Column(unique = true)
	private String mobile;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private Autherizationstatus autho;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	private Address address;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.username = email;
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
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

	public Autherizationstatus getAutho() {
		return autho;
	}

	public void setAutho(Autherizationstatus autho) {
		this.autho = autho;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority("OWNER");
		
		authorities.add(simpleGrantedAuthority);
		
		simpleGrantedAuthority=new SimpleGrantedAuthority("ADMIN");
		authorities.add(simpleGrantedAuthority);
		
		simpleGrantedAuthority=new SimpleGrantedAuthority("PASSANGER");
		
		authorities.add(simpleGrantedAuthority);
		
		System.out.println(authorities);
		
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "Myuser [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", gender=" + gender + ", dob=" + dob + ", role=" + role + ", autho=" + autho
				+ ", bookings=" + bookings + "]";
	}
	
	
	
	 
	
}
