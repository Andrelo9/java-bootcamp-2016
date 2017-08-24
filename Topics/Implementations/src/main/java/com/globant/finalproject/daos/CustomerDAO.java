package com.globant.finalproject.daos;

import java.sql.SQLException;
import java.util.List;

import com.globant.finalproject.entities.Customer;

/**
 * This class contains all possibles actions to do with the Customers in the
 * application like CRUD operations and rest calls.
 * 
 * @author andres.vaninetti
 *
 */
public interface CustomerDAO {

	/**
	 * Create a record in table user.
	 * 
	 * @throws SQLException
	 * 
	 * @POST
	 * 
	 */
	public void customerRegistration(int customerId, String customerNickname, String customerFirstname, String customerLastname,
			String customerPassword, String customerEmail) throws SQLException;

	/**
	 * Read a record from Customer in db.
	 * 
	 * @GET
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Customer> getCustomer(int customerId);

	/**
	 * Return all customer registered in the application.
	 * 
	 * @return List
	 */
	public List<Customer> getAllCustomers();

	/**
	 * Delete a customer from a db.
	 * 
	 * @DELETE
	 */
	public void deleteCustomer(int customerId);

}
