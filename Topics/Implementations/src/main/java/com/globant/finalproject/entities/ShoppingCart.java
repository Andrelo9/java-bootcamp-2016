package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This entity represent a virtual Shopping Cart. of this.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int userId;
	private int productId;
	private int productQuantity;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity
	 *            the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
