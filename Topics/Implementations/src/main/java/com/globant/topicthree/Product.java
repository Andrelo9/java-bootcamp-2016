package com.globant.topicthree;

/**
 * This class represent a product, and is used to populate a shopping cart.
 * 
 * @author andres.vaninetti
 *
 */
public class Product {

	private int id;

	/**
	 * Constructor method
	 * 
	 */
	public Product(int productId) {
		this.id = productId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
