package topiczerotwo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class SQLiteConnection implements SQLConnector {

	private static final String DATASOURCE_CONNECTION = "datasource.properties";

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
		InputStream input = SQLiteConnection.class.getClassLoader().getResourceAsStream(DATASOURCE_CONNECTION);
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
		connectionData = new ConnectionData(properties.getProperty("sqliteuser"), properties.getProperty("password"),
				properties.getProperty("sqliteurl"));
		try {
			connectionData.doDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
