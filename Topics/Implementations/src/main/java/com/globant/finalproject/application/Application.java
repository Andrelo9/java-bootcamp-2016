package com.globant.finalproject.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.globant.finalproject.daos.ShoppingCartController;

@SpringBootApplication
@ComponentScan(basePackageClasses=ShoppingCartController.class)
public class Application {
	
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}
