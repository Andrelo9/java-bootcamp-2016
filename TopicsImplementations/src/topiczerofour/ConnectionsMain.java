package topiczerofour;

public class ConnectionsMain {

	public static void main(String[] args) {

		// MySQL Connection
		ConnectionBuilder connectionBuilder = new MySQLConnection();
		SQLConnectionsDirector sqlConnectionsDirector = new SQLConnectionsDirector(connectionBuilder);
		sqlConnectionsDirector.buildConnection();
		SQLConnection sqlConnection = sqlConnectionsDirector.getSQLConnection();
		System.out.println(sqlConnection.toString());

		// PostgreSQL Connection
		connectionBuilder = new PostgreSQLConnection();
		sqlConnectionsDirector = new SQLConnectionsDirector(connectionBuilder);
		sqlConnectionsDirector.buildConnection();
		sqlConnection = sqlConnectionsDirector.getSQLConnection();
		System.out.println(sqlConnection.toString());

		// SQLite Connection
		connectionBuilder = new SQLiteConnection();
		sqlConnectionsDirector = new SQLConnectionsDirector(connectionBuilder);
		sqlConnectionsDirector.buildConnection();
		sqlConnection = sqlConnectionsDirector.getSQLConnection();
		System.out.println(sqlConnection.toString());
	}
}
