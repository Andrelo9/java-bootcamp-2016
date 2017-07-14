package topiczerofour;

/**
 * This class contains the basic information to build a PostgreSQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class PostgreSQLConnection implements ConnectionBuilder {

	private SQLConnection sqlConnection;

	public PostgreSQLConnection() {
		sqlConnection = new SQLConnection();
	}

	@Override
	public ConnectionBuilder buildDataBaseName() {
		sqlConnection.setDatabaseName("fifa.db");
		return this;
	}

	@Override
	public ConnectionBuilder buildHostName() {
		sqlConnection.setHostname("anotherhost");
		return this;
	}

	@Override
	public ConnectionBuilder buildPort() {
		sqlConnection.setPort(8081);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

}