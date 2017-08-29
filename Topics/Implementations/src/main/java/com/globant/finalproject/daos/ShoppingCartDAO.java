package com.globant.finalproject.daos;

import java.util.List;

import com.globant.finalproject.entities.ShoppingCart;

/**
 * This class contains all possibles actions to do with Shopping Cart in the
 * application like CRUD operations and rest calls.
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
	public void saveCart(int cartId, int cartcustomerId);

	/**
	 * Return information for required cart.
	 * 
	 * @param cartId
	 * @return
	 */
	public List<ShoppingCart> getCart(int cartId);

}
