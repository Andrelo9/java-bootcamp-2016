package com.globant.topicsix;

import java.io.Serializable;

/**
 * Entity class for users.
 * 
 * @author andres.vaninetti
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -5470697922874404469L;

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
