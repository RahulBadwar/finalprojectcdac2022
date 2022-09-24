package com.bookmybus.Bookmybus.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookmybus.Bookmybus.filters.JWTRequestFilter;



@EnableWebSecurity //mandatory
@Configuration //mandatory
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//dep : password encoder
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTRequestFilter filter;

	//configure auth provider builder to build in mem auth provider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	//configuration for role based authorization
	/*
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	 * 
	 */
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf().disable().
		exceptionHandling()
		.authenticationEntryPoint((request, response, ex) -> {
            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    ex.getMessage()
                );
            }).
		and().
		authorizeRequests()
	//	.antMatchers("/user").hasAnyRole("USER","ADMIN")		
		//.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/home","/api/auth/**").permitAll() //enabling global access to all urls with /api/auth 
		//only for JS clnts (react / angular)
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
	}
	
	//configure auth mgr bean : to be used in Auth REST controller
	@Bean
	public AuthenticationManager authenticatonMgr() throws Exception
	{
		return authenticationManagerBean();
	}
	
	

	
}

