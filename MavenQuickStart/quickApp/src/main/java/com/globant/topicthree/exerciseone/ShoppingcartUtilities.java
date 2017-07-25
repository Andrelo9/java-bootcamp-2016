package com.globant.topicthree.exerciseone;

/**
 * This is the Shopping Cart API for manage his features. 
 * 
 * @author andres.vaninetti
 *
 */
public interface ShoppingcartUtilities {
	
	public ShoppingCart getShoppingCart();
	
	public void deleteShoppingCart();
	
	public void addProduct(Product productToAdd);
	
	public void removeProduct(Product productToDelete);	

}
