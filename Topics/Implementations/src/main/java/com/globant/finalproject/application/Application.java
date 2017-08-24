package com.globant.finalproject.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point of Shopping Cart rest application. Here we specify to Spring
 * Boot, what are the components for scan and include in the core of the
 * application.
 * 
 * @author andres.vaninetti
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.globant.finalproject.controllers", "com.globant.finalproject.daos" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
