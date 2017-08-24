package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class to represent a Cart Item.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "cartitem")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartitemId;

	private int cartitemproductId;
	private int cartitemproductQuantity;

	/**
	 * @return the cartitemId
	 */
	public int getCartitemId() {
		return cartitemId;
	}

	/**
	 * @param cartitemId
	 *            the cartitemId to set
	 */
	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}

	/**
	 * @return the cartitemproductId
	 */
	public int getCartitemproductId() {
		return cartitemproductId;
	}

	/**
	 * @param cartitemproductId
	 *            the cartitemproductId to set
	 */
	public void setCartitemproductId(int cartitemproductId) {
		this.cartitemproductId = cartitemproductId;
	}

	/**
	 * @return the cartitemproductQuantity
	 */
	public int getCartitemproductQuantity() {
		return cartitemproductQuantity;
	}

	/**
	 * @param cartitemproductQuantity
	 *            the cartitemproductQuantity to set
	 */
	public void setCartitemproductQuantity(int cartitemproductQuantity) {
		this.cartitemproductQuantity = cartitemproductQuantity;
	}

	/**
	 * Compare two cart items.
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof CartItem)) {
			return false;
		} else {
			CartItem cartItemToCompare = (CartItem) object;
			return this.cartitemId == cartItemToCompare.cartitemId;
		}
	}
}
