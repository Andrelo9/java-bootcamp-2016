package topiczerotwo;

import java.io.IOException;
import java.sql.SQLException;

import topiczerothree.SQLProxy;

/**
 * Main class to test Abstract factory pattern with DB connections.
 * 
 * @author andres.vaninetti
 *
 */
public class EntryPointClass {

	public static void main(String[] args) throws IOException, SQLException {
		AbstractFactory factoryBuilder = FactoryBuilder.biuldFactory(DataBases.SQL);

		// MySQL connection
		SQLConnector sqlConnector = factoryBuilder.create(SQLContracts.MYSQL);
		sqlConnector.doConnect();		
		
		// PostgreSQL connection
		sqlConnector = factoryBuilder.create(SQLContracts.POSTGRESQL);
		sqlConnector.doConnect();

		// SQLite connection
		sqlConnector = factoryBuilder.create(SQLContracts.SQLITE);
		sqlConnector.doConnect();
		
		// Connection by proxy, waits 5 seconds to establish this.
		SQLProxy sqlProxy = new SQLProxy(factoryBuilder);
		sqlProxy.getFactoryBuilderProxy().create(SQLContracts.MYSQL).doConnect();
	}

}
