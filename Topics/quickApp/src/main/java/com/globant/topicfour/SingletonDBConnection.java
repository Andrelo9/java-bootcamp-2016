package com.globant.topicfour;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author andres.vaninetti
 * 
 *         Connecting to data base.
 *
 */
public class SingletonDBConnection {

	private static SingletonDBConnection singlettonDBConnection = null;
	private static Object flag = new Object();

	private ConnectionData connectionData;

	/**
	 * Constructor method
	 * 
	 * @throws IOException
	 * 
	 */
	private SingletonDBConnection()  {
		connectionData = new ConnectionData("root","root",
				"jdbc:mysql://localhost:3306/high_school?autoReconnect=true&useSSL=false");
		try {
			connectionData.doDBConnection();			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}

	}

	public static SingletonDBConnection getInstance() throws IOException {
		if (singlettonDBConnection == null) {
			synchronized (flag) {
				if (singlettonDBConnection == null) {
					singlettonDBConnection = new SingletonDBConnection();
				}
			}
		}
		return singlettonDBConnection;
	}

}
