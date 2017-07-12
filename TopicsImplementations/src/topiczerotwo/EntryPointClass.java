package topiczerotwo;

import java.io.IOException;

/**
 * Main class to test Abstract factory pattern with DB connections.
 * 
 * @author andres.vaninetti
 *
 */
public class EntryPointClass {

	// Types of DB
	private static final String ORACLE = "ORACLE";
	private static final String SQL = "SQL";

	// Differents implementations of DBMS SQL
	private static final String MY_SQL = "MYSQL";
	private static final String POSTGRE_SQL = "POSTGRESQL";
	private static final String LITE_SQL = "SQLITE";

	public static void main(String[] args) throws IOException {
		AbstractFactory factoryBuilder = FactoryBuilder.biuldFactory(SQL);

		// MySQL connection
		SQLConnector sqlConnector = factoryBuilder.create(MY_SQL);
		sqlConnector.doConnect();		

		sqlConnector = factoryBuilder.create(POSTGRE_SQL);
		sqlConnector.doConnect();

		sqlConnector = factoryBuilder.create(LITE_SQL);
		sqlConnector.doConnect();
	}

}
