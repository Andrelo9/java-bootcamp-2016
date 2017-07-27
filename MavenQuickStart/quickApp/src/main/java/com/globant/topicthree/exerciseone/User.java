package com.globant.topicthree.exerciseone;

import java.io.Serializable;

/**
 * Entity class for users.
 * 
 * @author andres.vaninetti
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;

	/**
	 * Default constructor.
	 * 
	 */
	public User() {

	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param id
	 * @param userName
	 */
	public User(int id, String userName) {
		this.userId = id;
		this.userName = userName;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Compare two users
	 * 
	 * @param userToCompare
	 * @return
	 */
	public boolean equals(User userToCompare) {
		if (userToCompare != null) {
			return this.userId == userToCompare.userId;
		} else {
			return false;
		}
	}

}
