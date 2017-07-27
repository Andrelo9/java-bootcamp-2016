package com.globant.topicthree.exerciseone;

/**
 * Factory patter to create different types of services.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartServiceFactory {

	public ShoppingCartServiceFactory() {
	}

	public static ShoppingCartService getShoppingCartController() {
		return new ShoppingCartController();
	}

	public static ShoppingCartService getRemoteShoppingCartWebService() throws InterruptedException {
		return new ShoppingCartServiceProxy(new ShoppingCartController());
	}

}
