package com.globant.topiczero.four;

/**
 * Base SQL features class, is used for every kind of SQL implementations to
 * instantiante a type of connect.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLConnection {

	private String databaseName;
	private String hostname;
	private int port;

	public SQLConnection() {

	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	public String toString() {
		return "DataBase:" + this.databaseName + " HostName:" + this.hostname + " Port:" + this.port;
	}
}
