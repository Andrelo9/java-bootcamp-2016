package com.globant.topicthree.exerciseone;

/**
 * Factory patter to create different types of servicies.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartServiceFactory {

	public ShoppingCartServiceFactory() {
	}

	public static ShoppingCartService getLocalService() {
		return new ShoppingCart();
	}

	public static ShoppingCartService getRemoteShoppingCartWebService() throws InterruptedException {
		return new ShoppingCartServiceProxy(new RemoteWebServiceClient());
	}

	public static ShoppingCartService getWebService() {
		return new ShoppingCartWebService();
	}

}
