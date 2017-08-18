package com.globant.finalproject.daos;

import java.util.List;

import com.globant.finalproject.entities.Product;

/**
 * Base API for CRUD product operations.
 * 
 * @author andres.vaninetti
 *
 */
public interface ProductDAO {

	/**
	 * Add a new product to the database.
	 * 
	 * @param productId
	 * @param productName
	 * @param productCategory
	 * @param productPrice
	 */
	public void addNewProduct(int productId, String productName, String productCategory, Float productPrice);

	/**
	 * Delete a product from the API.
	 * 
	 * @param productId
	 */
	public void deleteProduct(int productId);

	/**
	 * Return all products existing in the database.
	 * 
	 */
	public List<Product> getAllProducts();

	/**
	 * Return a product from the database.
	 * 
	 * @param productId
	 * @return
	 */
	public List<Product> getProduct(int productId);
}
