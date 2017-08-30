package com.globant.finalproject.daos;

import java.util.List;

import com.globant.finalproject.entities.Product;

/**
 * This class contains all possibles actions to do with Products in the
 * application like CRUD operations and rest calls.
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
	public void addNewProduct(Product product);

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

	/**
	 * Return all products that match with requested category
	 * 
	 * @param category
	 * @return
	 */
	public List<Product> findProductsByCategory(String category);

	/**
	 * Return all products that match with requested name
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> findProductsByName(String name);
}
