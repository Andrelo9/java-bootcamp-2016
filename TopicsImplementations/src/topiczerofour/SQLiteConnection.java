package topiczerofour;

/**
 * This class contains the basic information to build a SQLite connection.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLiteConnection implements ConnectionBuilder {

	private SQLConnection sqlConnection;

	public SQLiteConnection() {
		sqlConnection = new SQLConnection();
	}

	@Override
	public ConnectionBuilder buildDataBaseName() {
		sqlConnection.setDatabaseName("fiba.db");
		return this;
	}

	@Override
	public ConnectionBuilder buildHostName() {
		sqlConnection.setHostname("otherhost");
		return this;
	}

	@Override
	public ConnectionBuilder buildPort() {
		this.sqlConnection.setPort(8082);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

}
