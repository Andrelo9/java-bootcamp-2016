package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represent a product, and is used to populate a shopping cart.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	private String productName;
	private String productCategory;
	private Float productPrice;

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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory
	 *            the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productPrice
	 */
	public Float getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Compare two products
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof Product)) {
			return false;
		} else {
			Product productToCompare = (Product) object;
			return this.productId == productToCompare.productId;
		}
	}
}
