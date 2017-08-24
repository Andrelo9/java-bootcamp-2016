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

import com.globant.finalproject.daos.ShoppingCartDAO;
import com.globant.finalproject.entities.ShoppingCart;

@RestController
@RequestMapping(path="/shoppingCart")
public class CartController {
	
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	
	
	//*************************************************************************//
	//****************************CART CONTROLLER******************************//
	//*************************************************************************//
		
		@RequestMapping(value = "/cart/addCart", method = RequestMethod.POST)	
		public ResponseEntity<String> newProduct(@RequestBody @RequestParam int cartId,
															  @RequestParam int cartcustomerId) throws SQLException {
			shoppingCartDAO.saveCart(cartId,
									 cartcustomerId);
			return new ResponseEntity<String> ("Cart added", HttpStatus.CREATED);		
		}
		
		@RequestMapping(value = "/cart/getCart", method = RequestMethod.GET)
		public ResponseEntity<List<ShoppingCart>> getCart(@RequestBody @RequestParam int cartId) {
			return new ResponseEntity<List<ShoppingCart>>(shoppingCartDAO.getCart(cartId), HttpStatus.OK);
		}
		
}
