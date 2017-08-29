package com.globant.finalproject.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.ShoppingCart;

@Component
public class ShoppingCartImplementation implements ShoppingCartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveCart(int cartId, int cartcustomerId) {
		String query = "INSERT INTO shoppingcart VALUES(?,?)";
		this.jdbcTemplate.update(query, cartId, cartcustomerId);
	}

	@Override
	public List<ShoppingCart> getCart(int cartId) {
		String query = "SELECT * FROM shoppingcart WHERE cart_id = ?";
		return this.jdbcTemplate.query(query, new Object[] { cartId }, new BeanPropertyRowMapper<ShoppingCart>(ShoppingCart.class));
	}

}
