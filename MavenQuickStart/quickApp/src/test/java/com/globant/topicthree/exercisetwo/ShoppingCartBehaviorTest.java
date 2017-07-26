package com.globant.topicthree.exercisetwo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.globant.topicthree.exerciseone.Product;
import com.globant.topicthree.exerciseone.ShoppingCart;

import junit.framework.Assert;

/**
 * This class contains a set of test to prove the Shopping Cart functionality.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartBehaviorTest {

	@Test
	public void whenCreateAShoppingCartThenIsEmpty() {
		List<Product> prodToAdd = new ArrayList<Product>();
		ShoppingCart myShoppingCart = new ShoppingCart(prodToAdd);

		Assert.assertTrue("The cart is not empty", myShoppingCart.getProducts().isEmpty());
	}

	@Test
	public void whenAddAProductThenExistInCart() {
		Product productOne = new Product();
		ShoppingCart myShoppingCart = new ShoppingCart();
		myShoppingCart.addProduct(productOne);

		Assert.assertFalse("The cart is empty", myShoppingCart.getProducts().isEmpty());
	}

	@Test
	public void whenDeleteAProductThenRemoveFromList() {
		Product productOne = new Product();
		ShoppingCart myShoppingCart = new ShoppingCart();
		myShoppingCart.addProduct(productOne);
		myShoppingCart.removeProduct(productOne);

		Assert.assertTrue("The product has not been removed", myShoppingCart.getProducts().isEmpty());
	}

	@Test
	public void whenAddMoreThanFiveElementsThenAreNotIntroducedInTheCart() {
		Product productOne = new Product();
		Product productTwo = new Product();
		Product productThree = new Product();
		Product productFor = new Product();
		Product productFive = new Product();
		Product productSix = new Product();
		ShoppingCart myShoppingCart = new ShoppingCart();
		myShoppingCart.addProduct(productOne);
		myShoppingCart.addProduct(productTwo);
		myShoppingCart.addProduct(productThree);
		myShoppingCart.addProduct(productFor);
		myShoppingCart.addProduct(productFive);
		myShoppingCart.addProduct(productSix);

		Assert.assertEquals(5, myShoppingCart.getProducts().size());
	}

}
