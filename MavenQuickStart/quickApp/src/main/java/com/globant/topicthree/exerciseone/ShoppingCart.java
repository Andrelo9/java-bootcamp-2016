package com.globant.topicthree.exerciseone;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * This class represent a virtual Shopping Cart and provides the basic features
 * of this.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCart implements ShoppingCartService, Serializable {

	private static final int MAX_PRODUCTS_CAPACITY = 5;

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

	public ShoppingCart getShoppingCart() {
		return this;
	}	

	public void addProduct(Product productToAdd) {
		if (this.products.size() < MAX_PRODUCTS_CAPACITY) {
			this.products.add(productToAdd);
		}
	}

	public void removeProduct(Product productToDelete) {
		for (Product product:products) {
			if (product.getId().equals(productToDelete.getId())){			
				this.products.remove(product);
			}
		}
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
