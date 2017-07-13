package topiczerotwo;

import java.io.IOException;
import java.sql.SQLException;

public class PostgreSQLConnection extends AbstractSQLConnector {	

	private static final String PASSWORD2 = "password2";
	private static final String POSTGRESQLUSER = "postgresqluser";
	private static final String POSTGREURL = "postgreurl";
	
	private static PostgreSQLConnection singlettonDBConnection = null;
	private static Object flag = new Object();

	private ConnectionData connectionData;

	/**
	 * Constructor method
	 * 
	 * @throws IOException
	 * 
	 */
	private PostgreSQLConnection() throws IOException {

	}

	public static PostgreSQLConnection getInstance() throws IOException {
		if (singlettonDBConnection == null) {
			synchronized (flag) {
				if (singlettonDBConnection == null) {
					singlettonDBConnection = new PostgreSQLConnection();
				}
			}
		}
		return singlettonDBConnection;
	}

	@Override
	public void doConnect() throws SQLException {
		connectionData = getConnectionData(POSTGRESQLUSER,PASSWORD2,POSTGREURL);
		connectionData.doDBConnection();
	}
}
	
