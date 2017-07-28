package com.globant.topicthree.exerciseone;

/**
 * Base API for CRUD user operations.
 * 
 * @author andres.vaninetti
 *
 */
public interface UserService {

	/**
	 * Create a user.
	 * 
	 * @POST
	 * 
	 */
	public void createUser(Integer id, String name);

	/**
	 * Read an user from a data structure.
	 * 
	 * @GET
	 * 
	 * @param id
	 * @return
	 */
	public User readUser(Integer id);

	/**
	 * Update a user.
	 * 
	 * @PUT
	 * 
	 * @param userToUpdate
	 */
	public void updateUser(User userToUpdate);

	/**
	 * Delete a user from a data structure.
	 * 
	 * @DELETE
	 */
	public void deleteUser(Integer id);

}
