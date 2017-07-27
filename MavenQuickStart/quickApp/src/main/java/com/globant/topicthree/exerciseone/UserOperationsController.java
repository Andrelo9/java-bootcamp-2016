package com.globant.topicthree.exerciseone;

import java.util.ArrayList;
import java.util.List;

/**
 * API implementation of UserService for virtual Shopping Cart (CRUD).
 * 
 * @author andres.vaninetti
 *
 */
public class UserOperationsController implements UserService {

	private List<User> userDAOList;

	public UserOperationsController() {
		this.userDAOList = new ArrayList<User>();
	}

	public void createUser(int id, String name) {
		User userToCreate = new User(id, name);
		this.userDAOList.add(userToCreate);
	}

	public User readUser(int id) {
		if (this.userDAOList != null) {
			for (User user : this.userDAOList) {
				if (user.getUserId() == id) {
					return user;
				}
			}
		}
		return null;
	}

	public void updateUser(User userToUpdate) {
		if (this.userDAOList != null) {
			for (User user : this.userDAOList) {
				if (user.equals(userToUpdate)) {
					int index = this.userDAOList.indexOf(user);
					this.userDAOList.set(index, userToUpdate);
				}
			}
		}
	}

	public void deleteUser(int id) {
		if (this.userDAOList != null) {
			for (User user : this.userDAOList) {
				if (user.getUserId() == id) {
					this.userDAOList.remove(user);
				}
			}
		}
	}

}
