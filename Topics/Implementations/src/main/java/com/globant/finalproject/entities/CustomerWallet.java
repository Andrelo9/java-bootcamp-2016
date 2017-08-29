package com.globant.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for represent Wallets.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "customerwallet")
public class CustomerWallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;

	private int customerwalletId;
	private float amount;

	/**
	 * @return the walletId
	 */
	@Column(name = "wallet_id")
	public int getWalletId() {
		return walletId;
	}

	/**
	 * @param walletId
	 *            the walletId to set
	 */
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	/**
	 * @return the customerwalletId
	 */
	@Column(name = "customerwallet_id")
	public int getCustomerwalletId() {
		return customerwalletId;
	}

	/**
	 * @param customerwalletId
	 *            the customerwalletId to set
	 */
	public void setCustomerwalletId(int customerwalletId) {
		this.customerwalletId = customerwalletId;
	}

	/**
	 * @return the amount
	 */
	@Column(name = "amount")
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * Compare two wallets
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof CustomerWallet)) {
			return false;
		} else {
			CustomerWallet customerWalletToCompare = (CustomerWallet) object;
			return this.customerwalletId == customerWalletToCompare.customerwalletId;
		}
	}

}
