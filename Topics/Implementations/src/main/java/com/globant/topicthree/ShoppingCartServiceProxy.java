package com.globant.topicthree;

/**
 * Proxy class for work with services.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartServiceProxy implements ShoppingCartService {

	private ShoppingCartService shoppingcartController;

	public ShoppingCartServiceProxy(ShoppingCartService shoppingcartService) throws InterruptedException {
		Thread.sleep(1000); // Simulate delay to network connection.
		this.shoppingcartController = shoppingcartService;
	}

	public void addProduct(Product productToAdd) {
		this.shoppingcartController.addProduct(productToAdd);

	}

	public void removeProduct(Product productToDelete) {
		this.shoppingcartController.removeProduct(productToDelete);

	}

	public ShoppingCart checkOut() {
		return shoppingcartController.checkOut();
	}

}
