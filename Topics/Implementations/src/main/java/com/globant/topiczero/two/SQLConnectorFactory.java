package com.globant.topiczero.two;

import java.io.IOException;

/**
 * This class handling different instances of SQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLConnectorFactory extends AbstractFactory {

	@Override
	public SQLConnector create(SQLContracts sqlType) throws IOException {
		try {
			switch (sqlType) {
			case MYSQL:
				MySQLConnection mySQLConnection = MySQLConnection.getInstance();
				return mySQLConnection;
			case POSTGRESQL:
				PostgreSQLConnection postgreSQLConnection = PostgreSQLConnection.getInstance();
				return postgreSQLConnection;
			case SQLITE:
				SQLiteConnection sqLiteConnection = SQLiteConnection.getInstance();
				return sqLiteConnection;
			}
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return null;
	}
}