package topiczerotwo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQLConnection implements SQLConnector {

	private static final String DATASOURCE_CONNECTION = "datasource.properties";

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
	public void doConnect() {
		InputStream input = PostgreSQLConnection.class.getClassLoader().getResourceAsStream(DATASOURCE_CONNECTION);
		Properties properties = new Properties();
		try {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		connectionData = new ConnectionData(properties.getProperty("postgresqluser"), properties.getProperty("password"),
				properties.getProperty("postgreurl"));
		try {
			connectionData.doDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
