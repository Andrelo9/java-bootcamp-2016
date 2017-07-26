package com.globant.topicthree.exerciseone;

import java.util.UUID;

/**
 * This class represent a product, and is used to populate a shopping cart.
 * 
 * @author andres.vaninetti
 *
 */
public class Product {
	
	private String id;
	
	/**
	 * Constructor method
	 * 
	 */
	public Product() {
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
}
