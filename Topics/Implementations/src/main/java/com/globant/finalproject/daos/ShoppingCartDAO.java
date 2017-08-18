package com.globant.finalproject.daos;

import com.globant.finalproject.entities.Product;
import com.globant.finalproject.entities.ShoppingCart;

/**
 * This is the Shopping Cart API for manage his features. 
 * 
 * @author andres.vaninetti
 *
 */
public interface ShoppingCartDAO {
	
	/**
	 * Write in some data structure in memory in this case.
	 * 
	 * @return Shopping Cart
	 */
	public void saveCart(int cartId, int userId, int productId, int productQuantity);	
	
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
