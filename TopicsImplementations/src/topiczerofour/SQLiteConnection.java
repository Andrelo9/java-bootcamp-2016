package topiczerofour;

/**
 * This class contains the basic information to build a SQLite connection.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLiteConnection implements ConnectionBuilder {

	private static final int PORT = 8082;
	private static final String HOSTNAME = "otherhost";
	private static final String BASE_NAME = "fiba.db";
	private SQLConnection sqlConnection;

	public SQLiteConnection() {
		sqlConnection = new SQLConnection();
	}

	@Override
	public ConnectionBuilder buildDataBaseName() {
		sqlConnection.setDatabaseName(BASE_NAME);
		return this;
	}

	@Override
	public ConnectionBuilder buildHostName() {
		sqlConnection.setHostname(HOSTNAME);
		return this;
	}

	@Override
	public ConnectionBuilder buildPort() {
		this.sqlConnection.setPort(PORT);
		return this;
	}

	@Override
	public SQLConnection getSQLConnection() {
		return this.sqlConnection;
	}

}
