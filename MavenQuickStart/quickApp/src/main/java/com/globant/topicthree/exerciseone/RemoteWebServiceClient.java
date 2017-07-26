package com.globant.topicthree.exerciseone;

/**
 * This class create a connection between the client and web service.
 * 
 * @author andres.vaninetti
 *
 */
public class RemoteWebServiceClient implements ShoppingCartService {

	private ShoppingCartService WebService;

	public RemoteWebServiceClient() {
		// Connection from ShoppingCartService to WebService.
	}

	public ShoppingCart getShoppingCart() {
		return this.WebService.getShoppingCart();
	}

	public void addProduct(Product productToAdd) {
		this.WebService.addProduct(productToAdd);
	}

	public void removeProduct(Product productToDelete) {
		this.WebService.removeProduct(productToDelete);
	}

}
