package com.globant.finalproject.securityconfiguration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * This class setting a basic authentication for app actions.
 * 
 * @author andres.vaninetti
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("ADMIN").build());
		return manager;
	}
}
