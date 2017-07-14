package topiczerofour;

/**
 * This class contains the basic information to build a MySQL connection.
 * 
 * @author andres.vaninetti
 *
 */
public class MySQLConnection implements ConnectionBuilder {

	private SQLConnection sqlConnection;

	public MySQLConnection() {
		sqlConnection = new SQLConnection();
	}

	@Override
	public ConnectionBuilder buildDataBaseName() {
		sqlConnection.setDatabaseName("afa.db");
		return this;
	}

	@Override
	public ConnectionBuilder buildHostName() {
		sqlConnection.setHostname("localhost");
		return this;
	}

	@Override
	public ConnectionBuilder buildPort() {
		this.sqlConnection.setPort(8080);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

	public String toString() {
		return this.getClass().getName() + ": connection";
	}
}
