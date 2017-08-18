package com.globant.finalproject.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.finalproject.entities.Product;
import com.globant.finalproject.entities.User;

/**
 * API implementation of UserService for virtual Shopping Cart (CRUD).
 * 
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path="/shoppingCart")
public class ShoppingCartController {
	
	@Autowired	
	private UserDAO userDao;
	
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	

	//*************************************************************************//
	//****************************USER CONTROLLER******************************//
	//*************************************************************************//
	
	@RequestMapping(value = "/user/newUser", method = RequestMethod.POST)	
	public ResponseEntity<String> newUser(@RequestBody @RequestParam int userID,
													   @RequestParam String userNickName,
													   @RequestParam String firstName,
													   @RequestParam String lastName,
													   @RequestParam String password,
													   @RequestParam String eMail) throws SQLException {		
		userDao.userRegistration(userID,
								 userNickName,
								 firstName,
								 lastName,
								 password,
								 eMail);		
		return new ResponseEntity<String> ("User added", HttpStatus.CREATED);		
	}
	
	
	@RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser(@RequestBody @RequestParam int id) {
		return new ResponseEntity<List<User>>(userDao.getUser(id), HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@RequestBody @RequestParam int id) {
		userDao.deleteUser(id);
		return new ResponseEntity<String> ("User deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<List<User>>(userDao.getAllUsers(), HttpStatus.OK);
	}
	
	
	//*************************************************************************//
	//****************************PRODUCT CONTROLLER***************************//
	//*************************************************************************//
	
	@RequestMapping(value = "/product/newProduct", method = RequestMethod.POST)	
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
	
	@RequestMapping(value = "/product/deleteProduct", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@RequestBody @RequestParam int id) {
		productDao.deleteProduct(id);
		return new ResponseEntity<String> ("Product deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/getAllProducts", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productDao.getAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/getProduct", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProduct(@RequestBody @RequestParam int id) {
		return new ResponseEntity<List<Product>>(productDao.getProduct(id), HttpStatus.OK);
	}
	
	
	//*************************************************************************//
	//****************************PRODUCT CONTROLLER***************************//
	//*************************************************************************//
	
	@RequestMapping(value = "/shoppingCart/addCart", method = RequestMethod.POST)	
	public ResponseEntity<String> newProduct(@RequestBody @RequestParam int cartId,
														  @RequestParam int userId,
														  @RequestParam int productId,
														  @RequestParam int productQuantity) throws SQLException {
		shoppingCartDAO.saveCart(cartId,
								 userId,
								 productId,
								 productQuantity);
		return new ResponseEntity<String> ("Cart added", HttpStatus.CREATED);		
	}
	
}

	