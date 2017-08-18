package com.globant.finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for users.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userNickName;
	private String firstName;
	private String lastName;
	private String password;
	private String eMail;

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
	 * @return the userNickName
	 */
	public String getUserNickName() {
		return userNickName;
	}

	/**
	 * @param userNickName
	 *            the userNickName to set
	 */
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * Compare two users
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null) {
			return false;
		} else if (!(object instanceof User)) {
			return false;
		} else {
			User userToCompare = (User) object;
			return this.userId == userToCompare.userId;
		}
	}
}
