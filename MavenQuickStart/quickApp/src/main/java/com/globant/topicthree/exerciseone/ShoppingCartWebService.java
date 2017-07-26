package com.globant.topicthree.exerciseone;

/**
 * This class emulate a web service.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartWebService implements ShoppingCartService {
	
	private ShoppingCartService shoppingCartService = new ShoppingCart();

	public ShoppingCart getShoppingCart() {
		return this.shoppingCartService.getShoppingCart();
	}

	public void addProduct(Product productToAdd) {
		this.shoppingCartService.addProduct(productToAdd);
	}

	public void removeProduct(Product productToDelete) {
		this.shoppingCartService.removeProduct(productToDelete);
	}
	

}
