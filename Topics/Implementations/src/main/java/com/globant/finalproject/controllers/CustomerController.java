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

import com.globant.finalproject.daos.CustomerDAO;
import com.globant.finalproject.entities.Customer;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class contains information and definition about our Customers rest calls.
 * We've defined rest methods, parameters and path to manage the web services.
 * 
 * @author andres.vaninetti
 *
 */
@RestController
@RequestMapping(path="/shoppingCart")
public class CustomerController {
	
	@Autowired	
	private CustomerDAO customerDao;
	
	
	//*************************************************************************//
	//****************************CUSTOMER CONTROLLER**************************//
	//*************************************************************************//
		
		@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
		@ApiResponses({@ApiResponse(code = 500, message = "Table 'customer' not exists'"),
					   @ApiResponse(code = 400, message = "Bad Request"),					   
					   @ApiResponse(code = 200, message = "customer registered")})
		public ResponseEntity<String> customerRegistration(@RequestBody @RequestParam int customerId,
														   @RequestParam String customerNickname,
														   @RequestParam String customerFirstname,
														   @RequestParam String customerLastname,
														   @RequestParam String customerPassword,
														   @RequestParam String customerEmail) throws SQLException {		
			customerDao.customerRegistration(customerId,
									 		 customerNickname,
									 		 customerFirstname,
									 		 customerLastname,
									 		 customerPassword,
									 		 customerEmail);		
			return new ResponseEntity<String> ("Customer added", HttpStatus.CREATED);		
		}
		
		
		@RequestMapping(value = "/customer/getCustomer", method = RequestMethod.GET)
		public ResponseEntity<List<Customer>> getCustomer(@RequestBody @RequestParam int customerId) {
			return new ResponseEntity<List<Customer>>(customerDao.getCustomer(customerId), HttpStatus.OK);
		}	
		
		@RequestMapping(value = "/customer/deleteCustomer", method = RequestMethod.DELETE)
		@ApiResponses({@ApiResponse(code = 500, message = "Table 'customer' not exists'"),
			   		   @ApiResponse(code = 400, message = "Bad Request"),					   
			   		   @ApiResponse(code = 200, message = "customer removed")})
		public ResponseEntity<String> deleteCustomer(@RequestBody @RequestParam int customerId) {
			customerDao.deleteCustomer(customerId);
			return new ResponseEntity<String> ("Customer deleted", HttpStatus.OK);
		}
		
		@RequestMapping(value = "/customer/getAllCustomers", method = RequestMethod.GET)
		public ResponseEntity<List<Customer>> getAllCustomers() {
			return new ResponseEntity<List<Customer>>(customerDao.getAllCustomers(), HttpStatus.OK);
		}
}
