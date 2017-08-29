package com.globant.topicthree;

/**
 * This is the Shopping Cart API for manage his features. 
 * 
 * @author andres.vaninetti
 *
 */
public interface ShoppingCartService {
	
	/**
	 * Write in some data structure in memory in this case.
	 * 
	 * @return Shopping Cart
	 */
	public ShoppingCart checkOut();	
	
	/**
	 * Add a product to shopping cart.
	 * 
	 * @param productToAdd
	 */
	public void addProduct(Product productToAdd);
	
	/**
	 * Delete a product from the shopping cart.
	 * 
	 * @param productToDelete
	 */
	public void removeProduct(Product productToDelete);

}
