package com.globant.topicthree.exerciseone;

/**
 * This is the Shopping Cart API for manage his features. 
 * 
 * @author andres.vaninetti
 *
 */
public interface ShoppingCartService {
	
	/**
	 * Return a Shopping Cart
	 * 
	 * @return Shopping Cart
	 */
	public ShoppingCart getShoppingCart();	
	
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
