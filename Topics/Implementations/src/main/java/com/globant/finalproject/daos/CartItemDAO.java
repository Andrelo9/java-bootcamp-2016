package com.globant.finalproject.daos;

import java.util.List;

import com.globant.finalproject.entities.CartItem;

/**
 * This class contains all possibles actions to do with Cart items in the
 * application.
 * 
 * @author andres.vaninetti
 *
 */
public interface CartItemDAO {

	/**
	 * Delete a product from the Cart items like CRUD operations and rest calls.
	 * 
	 * @param productToDelete
	 */
	public void addProduct(int cartitemId, int cartitemproductId, int cartitemproductQuantity);

	/**
	 * Delete a product from the Cart items.
	 * 
	 * @param productToDelete
	 */
	public void removeProduct(int cartitemId);

	/**
	 * Return a requested Cart item by id.
	 * 
	 * @param cartitemId
	 * @return
	 */
	public List<CartItem> getCartItem(int cartitemId);
}
