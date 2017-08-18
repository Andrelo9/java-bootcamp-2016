package com.globant.finalproject.daos;

import java.sql.SQLException;
import java.util.List;

import com.globant.finalproject.entities.User;

/**
 * Base API for CRUD user operations.
 * 
 * @author andres.vaninetti
 *
 */
public interface UserDAO {

	/**
	 * Create a record in table user.
	 * @throws SQLException 
	 * 
	 * @POST
	 * 
	 */
	public void userRegistration(int userID, String userNickName, String firstName, String lastName, String password, String eMail) throws SQLException;

	/**
	 * Read a record from User in db.
	 * 
	 * @GET
	 * 
	 * @param id
	 * @return
	 */
	public List<User> getUser(int id);
	
	/**
	 * Return all user registered in the application.
	 * 
	 * @return List
	 */
	public List<User> getAllUsers();

	/**
	 * Delete a user from a db.
	 * 
	 * @DELETE
	 */
	public void deleteUser(int id);

}
