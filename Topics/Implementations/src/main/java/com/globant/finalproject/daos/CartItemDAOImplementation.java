package com.globant.finalproject.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.CartItem;

@Component
public class CartItemDAOImplementation implements CartItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CartItemDAOImplementation() {

	}

	@Override
	public void addProduct(CartItem cartitem) {
		String query = "INSERT INTO cartitem VALUES(?, ?, ?)";
		this.jdbcTemplate.update(query, cartitem.getCartitemId(), cartitem.getCartitemproductId(), cartitem.getCartitemproductQuantity());
	}

	@Override
	public void removeProduct(int cartitemId) {
		String query = "DELETE FROM cartitem WHERE cartitem_id = ?";
		this.jdbcTemplate.update(query, cartitemId);

	}

	@Override
	public List<CartItem> getCartItem(int cartitemId) {
		String query = "SELECT * FROM cartitem WHERE cartitem_id = ?";
		return this.jdbcTemplate.query(query, new Object[] { cartitemId }, new BeanPropertyRowMapper<CartItem>(CartItem.class));
	}

}
