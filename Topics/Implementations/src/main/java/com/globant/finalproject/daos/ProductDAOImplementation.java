package com.globant.finalproject.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.Product;

@Component
public class ProductDAOImplementation implements ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProductDAOImplementation() {

	}

	@Override
	public void addNewProduct(int productID, String productName, String productCategory, Float productPrice) {
		String query = "INSERT INTO products VALUES (?, ?, ?, ?)";
		this.jdbcTemplate.update(query, productID, productName, productCategory, productPrice);
	}

	@Override
	public void deleteProduct(int productID) {
		String query = "DELETE FROM products WHERE product_id = ?";
		this.jdbcTemplate.update(query, productID);
	}

	@Override
	public List<Product> getAllProducts() {
		String query = "SELECT * FROM products";
		return this.jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public List<Product> getProduct(int productID) {
		String query = "SELECT * FROM products WHERE product_id = ?";
		return this.jdbcTemplate.query(query, new Object[] { productID }, new BeanPropertyRowMapper<Product>(Product.class));
	}

}
