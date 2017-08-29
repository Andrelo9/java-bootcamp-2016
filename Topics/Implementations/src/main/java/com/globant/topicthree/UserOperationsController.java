package com.globant.topicthree;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * API implementation of UserService for virtual Shopping Cart (CRUD).
 * 
 * @author andres.vaninetti
 *
 */
public class UserOperationsController implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserOperationsController.class.getName());

	private Map<Integer, User> userDAOMap;

	public UserOperationsController() {
		this.userDAOMap = new HashMap<Integer, User>();
	}

	public void createUser(Integer id, String name) {
		this.userDAOMap.put(id, new User(id, name));
	}

	public User readUser(Integer id) {
		if (this.userDAOMap != null) {
			return this.userDAOMap.get(id);
		}
		return null;
	}

	public void updateUser(User userToUpdate) {
		if (this.userDAOMap != null) {
			this.userDAOMap.put(userToUpdate.getUserId(), userToUpdate);
		}
	}

	public void deleteUser(Integer id) {
		if (this.userDAOMap != null) {
			this.userDAOMap.remove(id);
		}
	}

}
