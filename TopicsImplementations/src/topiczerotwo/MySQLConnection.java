package topiczerotwo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author andres.vaninetti
 * 
 *         Connection to DB using singleton pattern.
 *
 */
public class MySQLConnection implements SQLConnector {

	private static final String DATASOURCE_CONNECTION = "datasource.properties";

	private static MySQLConnection singlettonDBConnection = null;
	private static Object flag = new Object();

	private ConnectionData connectionData;

	/**
	 * Constructor method
	 * 
	 * @throws IOException
	 * 
	 */
	private MySQLConnection() throws IOException {

	}

	public static MySQLConnection getInstance() throws IOException {
		if (singlettonDBConnection == null) {
			synchronized (flag) {
				if (singlettonDBConnection == null) {
					singlettonDBConnection = new MySQLConnection();
				}
			}
		}
		return singlettonDBConnection;
	}

	@Override
	public void doConnect() {
		InputStream input = MySQLConnection.class.getClassLoader().getResourceAsStream(DATASOURCE_CONNECTION);
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
		connectionData = new ConnectionData(properties.getProperty("user"), properties.getProperty("password"),
				properties.getProperty("localhost"));
		try {
			connectionData.doDBConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
