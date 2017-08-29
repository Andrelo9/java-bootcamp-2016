package com.globant.topiczero.four;

/**
 * This class contains the basic information to build a PostgreSQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class PostgreSQLConnection implements ConnectionBuilder {

	private static final int PORT = 8081;
	private static final String HOST = "anotherhost";
	private static final String BASE_NAME = "fifa.db";
	private SQLConnection sqlConnection;

	public PostgreSQLConnection() {
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
		sqlConnection.setPort(PORT);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

}