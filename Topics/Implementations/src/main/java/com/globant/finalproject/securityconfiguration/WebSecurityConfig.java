package com.globant.finalproject.securityconfiguration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * This class manage authentication and logout for the application.
 * 
 * @author andres.vaninetti
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {
	
	private static final String URL_LOGOUT = "http://localhost:8080/shoppingCart/logout";
	private static final String ROLE = "USER";
	private static final String PASSWORD = "password";
	private static final String NAME = "name";

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername(NAME).password(PASSWORD).roles(ROLE).build());
		return manager;
	}
	
	protected void configure(HttpSecurity http) throws Exception {		
		 		http
		 			.logout()
		 				.logoutUrl(URL_LOGOUT)
		 				.invalidateHttpSession(true)
		 			.and()
		 			.authorizeRequests()
		 				.anyRequest().authenticated()
		 				.and()
		 			.formLogin()
		 				.and()
		 			.httpBasic();
		 	}	
}
