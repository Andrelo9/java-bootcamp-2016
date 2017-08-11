package com.globant.topiczerotwo;

import java.io.IOException;

/**
 * @author andres.vaninetti
 * 
 *         Connection to DB using singleton pattern.
 *
 */
public class MySQLConnection extends AbstractSQLConnector {	

	private static final String PASSWORD1 = "password1";
	private static final String USER = "user";
	private static final String SQLURL = "sqlurl";
	
	private static MySQLConnection singlettonDBConnection = null;
	private static Object flag = new Object();

	private ConnectionData connectionData;

	/**
	 * Constructor method
	 * 
	 * @throws IOException
	 * 
	 */
	private MySQLConnection() throws IOException {

	}

	public static MySQLConnection getInstance() throws IOException {
		if (singlettonDBConnection == null) {
			synchronized (flag) {
				if (singlettonDBConnection == null) {
					singlettonDBConnection = new MySQLConnection();
				}
			}
		}
		return singlettonDBConnection;
	}

	@Override
	public void doConnect() {
		connectionData = getConnectionData(USER,PASSWORD1,SQLURL);
		connectionData.doDBConnection();		
	}

}
