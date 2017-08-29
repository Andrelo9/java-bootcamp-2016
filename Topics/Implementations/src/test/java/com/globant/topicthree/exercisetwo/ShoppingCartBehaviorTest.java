package com.globant.topicthree.exercisetwo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.globant.topicthree.Product;
import com.globant.topicthree.ShoppingCart;
import com.globant.topicthree.ShoppingCartController;
import com.globant.topicthree.ShoppingCartService;
import com.globant.topicthree.ShoppingCartServiceFactory;

import junit.framework.Assert;

/**
 * This class contains a set of test to prove the Shopping Cart functionality.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartBehaviorTest {

	private static final int PLAYADITO_ID = 001;

	@Test
	public void whenCreateAShoppingCartThenIsEmpty() {
		List<Product> prodToAdd = new ArrayList<Product>();
		ShoppingCart myShoppingCart = new ShoppingCart(prodToAdd);

		Assert.assertTrue("The cart is not empty", myShoppingCart.getProducts().isEmpty());
	}

	@Test
	public void whenAddAProductThenExistInCart() {
		ShoppingCartService shoppingCartService = ShoppingCartServiceFactory.getShoppingCartController();
		Product productOne = new Product(PLAYADITO_ID);
		shoppingCartService.addProduct(productOne);
		ShoppingCart shoppingCart = shoppingCartService.checkOut();

		Assert.assertFalse("The cart is empty", shoppingCart.getProducts().isEmpty());
	}

	@Test
	public void whenDeleteAProductThenRemoveFromList() {
		ShoppingCartService shoppingCartService = ShoppingCartServiceFactory.getShoppingCartController();
		Product productOne = new Product(PLAYADITO_ID);
		shoppingCartService.addProduct(productOne);
		shoppingCartService.removeProduct(productOne);
		ShoppingCart shoppingCart = shoppingCartService.checkOut();

		Assert.assertTrue("The product has not been removed", shoppingCart.getProducts().isEmpty());
	}

}
