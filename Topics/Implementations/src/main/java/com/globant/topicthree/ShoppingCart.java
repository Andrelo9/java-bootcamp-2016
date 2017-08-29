package com.globant.topicthree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * This entity represent a virtual Shopping Cart. of this.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> products;

	private String id;

	/**
	 * Default constructor.
	 * 
	 */
	public ShoppingCart() {
		this.products = new LinkedList<Product>();
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Constructor with parameters.
	 * 
	 */
	public ShoppingCart(List<Product> products) {
		this.products = products;
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Return a list of products includes in the shop cart.
	 * 
	 * @return List
	 */
	public List<Product> getProducts() {
		return this.products;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
