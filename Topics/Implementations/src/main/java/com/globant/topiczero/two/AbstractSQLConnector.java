package com.globant.topiczero.two;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class try to extract common behavior between connections.
 * 
 * @author andres.vaninetti
 *
 */
public abstract class AbstractSQLConnector implements SQLConnector {
	
	private static final String DATASOURCE_CONNECTION = "dataconnection.properties";
	
	public ConnectionData getConnectionData (String user, String password, String urlFormat) {
		InputStream input = AbstractSQLConnector.class.getClassLoader().getResourceAsStream(DATASOURCE_CONNECTION);
		Properties properties = new Properties();
		try {
			properties.load(input);
			if (input != null) {
				input.close();
			}
			return new ConnectionData(properties.getProperty(user), properties.getProperty(password),
					properties.getProperty(urlFormat));			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
