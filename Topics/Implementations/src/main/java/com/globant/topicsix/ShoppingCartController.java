package com.globant.topicsix;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class create a connection between the client and web service.
 * 
 * @author andres.vaninetti
 *
 */
@RestController
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
	
	@RequestMapping("/product")
	public Product getProduct(@RequestParam(value="id",defaultValue="001") int id) {
		return new Product(id);
	}
	
	

}
