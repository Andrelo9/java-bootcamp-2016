package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for represent Customers.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	private String customerNickname;
	private String customerFirstname;
	private String customerLastname;
	private String customerPassword;
	private String customerEmail;

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerNickname
	 */
	public String getCustomerNickname() {
		return customerNickname;
	}

	/**
	 * @param customerNickname
	 *            the customerNickname to set
	 */
	public void setCustomerNickname(String customerNickname) {
		this.customerNickname = customerNickname;
	}

	/**
	 * @return the customerFirstname
	 */
	public String getCustomerFirstname() {
		return customerFirstname;
	}

	/**
	 * @param customerFirstname
	 *            the customerFirstname to set
	 */
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}

	/**
	 * @return the customerLastname
	 */
	public String getCustomerLastname() {
		return customerLastname;
	}

	/**
	 * @param customerLastname
	 *            the customerLastname to set
	 */
	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}

	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * @param customerPassword
	 *            the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail
	 *            the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Compare two customers
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof Customer)) {
			return false;
		} else {
			Customer customerToCompare = (Customer) object;
			return this.customerId == customerToCompare.customerId;
		}
	}

}
