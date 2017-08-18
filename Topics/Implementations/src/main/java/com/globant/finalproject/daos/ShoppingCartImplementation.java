package com.globant.finalproject.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.Product;

@Component
public class ShoppingCartImplementation implements ShoppingCartDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveCart(int cartId, int userId, int productId, int productQuantity) {
		String query = "INSERT INTO shoppingcart VALUES (?,?,?,?)";
		this.jdbcTemplate.update(query, cartId, userId, productId, productQuantity);		
	}

	@Override
	public void addProduct(Product productToAdd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Product productToDelete) {
		// TODO Auto-generated method stub
		
	}

}
