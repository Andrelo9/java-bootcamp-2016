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

import com.globant.finalproject.daos.CartItemDAO;
import com.globant.finalproject.entities.CartItem;


/**
 * This class contains information and definition about our Cart Item rest calls.
 * We've defined rest methods, parameters and path to manage the web services.
 *
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path="/shoppingCart")
public class CartItemController {	
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	
	
	//*************************************************************************//
	//****************************CART ITEMS CONTROLLER************************//
	//*************************************************************************//
	
	@RequestMapping(value = "/cart/cartItems/addProduct", method = RequestMethod.POST)	
	public ResponseEntity<String> addProduct(@RequestBody @RequestParam int cartitemId,
														  @RequestParam int cartitemproductId,
														  @RequestParam int cartitemproductQuantity) throws SQLException {
		cartItemDAO.addProduct(cartitemId,
							   cartitemproductId,
							   cartitemproductQuantity);
		return new ResponseEntity<String> ("Product added to cart items", HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = "/cart/cartItems/removeProduct", method = RequestMethod.DELETE)	
	public ResponseEntity<String> removeProduct(@RequestBody @RequestParam int cartitemId) {
		cartItemDAO.removeProduct(cartitemId);
		return new ResponseEntity<String> ("Product deleted from cart item", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cart/cartItems/getCartItem", method = RequestMethod.GET)
	public ResponseEntity<List<CartItem>> getCartItem(@RequestBody @RequestParam int cartitemId) {
		return new ResponseEntity<List<CartItem>>(cartItemDAO.getCartItem(cartitemId), HttpStatus.OK);
	}	
	
}

	