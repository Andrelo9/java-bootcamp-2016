package com.globant.finalproject.controllers;

import static com.globant.finalproject.endpoints.ApiEndpoints.CART_ADD;
import static com.globant.finalproject.endpoints.ApiEndpoints.CART_GET;
import static com.globant.finalproject.endpoints.ApiEndpoints.SHOPPINGCART;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.finalproject.daos.ShoppingCartDAO;
import com.globant.finalproject.entities.ShoppingCart;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class contains information and definition about our Carts rest calls.
 * We've defined rest methods, parameters and path to manage web services.
 * 
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path = SHOPPINGCART)
public class CartController {
	
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	
		
	@RequestMapping(value = CART_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 500, message = "Duplicate entry for primary key"),
				   @ApiResponse(code = 500, message = "Table 'shoppingcart' not exists'"),
				   @ApiResponse(code = 200, message = "Cart added")})	
	public ResponseEntity<String> newProduct(@RequestBody ShoppingCart shoppingcart) throws SQLException {
		shoppingCartDAO.saveCart(shoppingcart);
		return new ResponseEntity<String> ("Cart added", HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = CART_GET, method = RequestMethod.GET)
	public ResponseEntity<List<ShoppingCart>> getCart(@RequestBody @RequestParam int cartId) {
		return new ResponseEntity<List<ShoppingCart>>(shoppingCartDAO.getCart(cartId), HttpStatus.OK);
	}
	
}
