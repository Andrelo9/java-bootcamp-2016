package com.globant.topicthree.exerciseone;

import java.util.LinkedList;
import java.util.List;

/**
 * This class create a connection between the client and web service.
 * 
 * @author andres.vaninetti
 *
 */
public class ShoppingCartController implements ShoppingCartService {

	private List<Product> products;

	public ShoppingCartController() {
		this.products = new LinkedList<Product>();
	}

	public void addProduct(Product productToAdd) {
		this.products.add(productToAdd);
	}

	public void removeProduct(Product productToDelete) {
		for (Product product : products) {
			if (product.getId() == productToDelete.getId()) {
				this.products.remove(product);
			}
		}
	}

	public ShoppingCart checkOut() {
		return new ShoppingCart(products);
	}
	
	

}
