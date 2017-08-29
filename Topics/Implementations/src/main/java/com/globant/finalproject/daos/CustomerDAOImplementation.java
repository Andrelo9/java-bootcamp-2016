package com.globant.finalproject.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.Customer;

@Component
public class CustomerDAOImplementation implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public CustomerDAOImplementation() {

	}

	@Override
	public void customerRegistration(int customerId, String customerNickname, String customerFirstname, String customerLastname,
			String customerPassword, String customerEmail) throws SQLException {
		String query = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(query, customerId, customerNickname, customerFirstname, customerLastname, customerPassword, customerEmail);
	}

	@Override
	public List<Customer> getCustomer(int customerId) {
		String query = "SELECT * FROM customer WHERE customer_id = ?";
		return this.jdbcTemplate.query(query, new Object[] { customerId }, new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	@Override
	public void deleteCustomer(int customerId) {
		String query = "DELETE FROM customer WHERE customer_id = ?";
		this.jdbcTemplate.update(query, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		String query = "SELECT * FROM customer";
		return this.jdbcTemplate.query(query, new Object[] {}, new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	@Override
	public void buyShoppingCart(int cartId) {	
		
	}

}
