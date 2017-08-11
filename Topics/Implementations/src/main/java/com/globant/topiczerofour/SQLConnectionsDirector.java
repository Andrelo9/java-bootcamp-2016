package com.globant.topiczerofour;

/**
 * This class build a specific connection using a Builder Director
 * 
 * @author andres.vaninetti
 *
 */
public class SQLConnectionsDirector {

	private ConnectionBuilder connectionBuilder = null;

	public SQLConnectionsDirector(ConnectionBuilder connectionBuilder) {
		this.connectionBuilder = connectionBuilder;
	}

	public void buildConnection() {
		this.connectionBuilder
		.buildDataBaseName()
		.buildHostName()
		.buildPort();
	}

	public SQLConnection getSQLConnection() {
		return this.connectionBuilder.getSQLConnection();
	}

}
