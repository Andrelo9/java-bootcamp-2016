package com.globant.topiczero.two;

import java.sql.SQLException;

public interface SQLConnector {

	/**
	 * This method provides a DB connection, depending on the type of SQL DB
	 * used.
	 * @throws SQLException 
	 * 
	 */
	public void doConnect() throws SQLException;

	/* Thinking about another approach to the solution, you could overload
	 the method doConnect with different numbers of parameters and create
	 different
	 connections by building the URL according to the parameters used. */
}
