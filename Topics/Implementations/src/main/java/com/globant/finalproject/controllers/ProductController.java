package com.globant.finalproject.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.finalproject.daos.ProductDAO;
import com.globant.finalproject.entities.Product;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.globant.finalproject.enumerates.ApiEndpoints.SHOPPINGCART;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_DELETE;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_GET_ALLPRODUCT;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_GET_BYCATEGORY;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_GET_BYNAME;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_GET_PRODUCT;
import static com.globant.finalproject.enumerates.ApiEndpoints.PRODUCT_REGISTRATION;

/**
 * This class contains information and definition about our Products rest calls.
 * We've defined rest methods, parameters and path to manage the web services.
 * 
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path = SHOPPINGCART)
public class ProductController {
	
	@Autowired
	private ProductDAO productDao;
	
	
	//*************************************************************************//
	//****************************PRODUCT CONTROLLER***************************//
	//*************************************************************************//
		
	@RequestMapping(value = PRODUCT_REGISTRATION, method = RequestMethod.POST)
	@ApiResponses({@ApiResponse(code = 500, message = "Table 'product' not exists'"),
				   @ApiResponse(code = 400, message = "Bad Request"),					   
				   @ApiResponse(code = 200, message = "product registered")})
	public ResponseEntity<String> newProduct(@RequestBody @RequestParam int productId,
														  @RequestParam String productName,
														  @RequestParam String productCategory,
														  @RequestParam float productPrice) throws SQLException {
		productDao.addNewProduct(productId,
								 productName,
								 productCategory,
								 productPrice);
		return new ResponseEntity<String> ("Product added", HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = PRODUCT_DELETE, method = RequestMethod.DELETE)
	@ApiResponses({@ApiResponse(code = 500, message = "Table 'product' not exists'"),
		   		   @ApiResponse(code = 400, message = "Bad Request"),					   
		   		   @ApiResponse(code = 200, message = "product deleted")})
	public ResponseEntity<String> deleteProduct(@RequestBody @RequestParam int id) {
		productDao.deleteProduct(id);
		return new ResponseEntity<String> ("Product deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value = PRODUCT_GET_ALLPRODUCT, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productDao.getAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = PRODUCT_GET_PRODUCT, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProduct(@RequestBody @RequestParam int productId) {
		return new ResponseEntity<List<Product>>(productDao.getProduct(productId), HttpStatus.OK);
	}
	
	@RequestMapping(value = PRODUCT_GET_BYCATEGORY, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByCategory(@RequestBody @RequestParam String productCategory) {
		return new ResponseEntity<List<Product>>(productDao.findProductsByCategory(productCategory), HttpStatus.OK);
	}
	
	@RequestMapping(value = PRODUCT_GET_BYNAME, method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByName(@RequestBody @RequestParam String productName) {
		return new ResponseEntity<List<Product>>(productDao.findProductsByName(productName), HttpStatus.OK);
	}
}
