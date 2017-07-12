package topiczerotwo;

import java.io.IOException;

/**
 * This class handling different instances of SQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLConnectorFactory extends AbstractFactory {

	private static final String SQLITE = "SQLITE";
	private static final String POSTGRESQL = "POSTGRESQL";
	private static final String MYSQL = "MYSQL";

	@Override
	public SQLConnector create(String sqlType) throws IOException {
		if (sqlType == null) {
			return null;
		}
		if (sqlType == MYSQL) {
			MySQLConnection mySQLConnection = MySQLConnection.getInstance();
			return mySQLConnection;
		} else if (sqlType == POSTGRESQL) {
			PostgreSQLConnection postgreSQLConnection = PostgreSQLConnection.getInstance();
			return postgreSQLConnection;
		} else if (sqlType == SQLITE) {
			SQLiteConnection sqLiteConnection = SQLiteConnection.getInstance();
			return sqLiteConnection;
		}
		return null;
	}

}
