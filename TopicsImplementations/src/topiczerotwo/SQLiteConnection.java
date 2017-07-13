package topiczerotwo;

import java.io.IOException;

public class SQLiteConnection extends AbstractSQLConnector {	

	private static final String PASSWORD3 = "password3";
	private static final String SQLITEURL = "sqliteurl";
	private static final String SQLITEUSER = "sqliteuser";
	
	private static SQLiteConnection singlettonDBConnection = null;
	private static Object flag = new Object();

	private ConnectionData connectionData;

	/**
	 * Constructor method
	 * 
	 * @throws IOException
	 * 
	 */
	private SQLiteConnection() throws IOException {

	}

	public static SQLiteConnection getInstance() throws IOException {
		if (singlettonDBConnection == null) {
			synchronized (flag) {
				if (singlettonDBConnection == null) {
					singlettonDBConnection = new SQLiteConnection();
				}
			}
		}
		return singlettonDBConnection;
	}

	@Override
	public void doConnect() {
		connectionData = getConnectionData(SQLITEUSER,PASSWORD3,SQLITEURL);
		connectionData.doDBConnection();		
	}
}
