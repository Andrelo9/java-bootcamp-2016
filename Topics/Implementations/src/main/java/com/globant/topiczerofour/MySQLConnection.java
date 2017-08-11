package com.globant.topiczerofour;

/**
 * This class contains the basic information to build a MySQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class MySQLConnection implements ConnectionBuilder {

	private static final int PORT = 8080;
	private static final String HOST = "localhost";
	private static final String BASE_NAME = "fifa.db";
	private SQLConnection sqlConnection;

	public MySQLConnection() {
		sqlConnection = new SQLConnection();
	}

	@Override
	public ConnectionBuilder buildDataBaseName() {
		sqlConnection.setDatabaseName(BASE_NAME);
		return this;
	}

	@Override
	public ConnectionBuilder buildHostName() {
		sqlConnection.setHostname(HOST);
		return this;
	}

	@Override
	public ConnectionBuilder buildPort() {
		this.sqlConnection.setPort(PORT);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

	public String toString() {
		return this.getClass().getName() + ": connection";
	}
}
