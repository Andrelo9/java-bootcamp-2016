package com.globant.topicthree.exerciseone;

/**
 * Proxy class for work with services.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartServiceProxy implements ShoppingCartService {

	private ShoppingCartService shoppingcartUtilities;

	public ShoppingCartServiceProxy(ShoppingCartService shoppingcartService) throws InterruptedException {
		Thread.sleep(1000); // Add delay throug the proxy.
		this.shoppingcartUtilities = shoppingcartService;
	}

	public ShoppingCart getShoppingCart() {
		return this.shoppingcartUtilities.getShoppingCart();
	}

	public void addProduct(Product productToAdd) {
		this.shoppingcartUtilities.addProduct(productToAdd);

	}

	public void removeProduct(Product productToDelete) {
		this.shoppingcartUtilities.removeProduct(productToDelete);

	}

}
