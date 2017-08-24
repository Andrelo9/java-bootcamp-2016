package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This entity represent a virtual Shopping Cart
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

	private int cartcustomerId;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartcustomerId
	 */
	public int getCartcustomerId() {
		return cartcustomerId;
	}

	/**
	 * @param cartcustomerId
	 *            the cartcustomerId to set
	 */
	public void setCartcustomerId(int cartcustomerId) {
		this.cartcustomerId = cartcustomerId;
	}

	/**
	 * Compare two carts
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof ShoppingCart)) {
			return false;
		} else {
			ShoppingCart shoppingCartToCompare = (ShoppingCart) object;
			return this.cartId == shoppingCartToCompare.cartId;
		}
	}

}
