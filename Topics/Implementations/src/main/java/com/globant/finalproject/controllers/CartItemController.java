package com.globant.finalproject.controllers;

import static com.globant.finalproject.endpoints.ApiEndpoints.CARTITEM_ADD;
import static com.globant.finalproject.endpoints.ApiEndpoints.CARTITEM_GET;
import static com.globant.finalproject.endpoints.ApiEndpoints.CARTITEM_REMOVE;
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

import com.globant.finalproject.daos.CartItemDAO;
import com.globant.finalproject.entities.CartItem;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class contains information and definition about our Cart Item rest calls.
 * We've defined rest methods, parameters and path to manage the web services.
 *
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path = SHOPPINGCART)
public class CartItemController {	
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	
	@RequestMapping(value = CARTITEM_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 500, message = "Duplicate entry for primary key"),
				   @ApiResponse(code = 500, message = "Table 'cartitem' not exists'"),
				   @ApiResponse(code = 200, message = "Product added to CartItem")})
	public ResponseEntity<String> addProduct(@RequestBody CartItem cartitem) throws SQLException {
		cartItemDAO.addProduct(cartitem);
		return new ResponseEntity<String> ("Product added to cart items", HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = CARTITEM_GET, method = RequestMethod.DELETE)
	@ApiResponses({@ApiResponse(code = 400, message = "Bad Request"),
		   		   @ApiResponse(code = 500, message = "Table 'cartitem' not exists'"),
		   		   @ApiResponse(code = 200, message = "Product removed from Cart Items")})
	public ResponseEntity<String> removeProduct(@RequestBody @RequestParam int cartitemId) {
		cartItemDAO.removeProduct(cartitemId);
		return new ResponseEntity<String> ("Product deleted from cart item", HttpStatus.OK);
	}
	
	@RequestMapping(value = CARTITEM_REMOVE, method = RequestMethod.GET)
	public ResponseEntity<List<CartItem>> getCartItem(@RequestBody @RequestParam int cartitemId) {
		return new ResponseEntity<List<CartItem>>(cartItemDAO.getCartItem(cartitemId), HttpStatus.OK);
	}	
	
}

	