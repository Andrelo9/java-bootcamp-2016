package topiczerotwo;

import java.sql.SQLException;

/**
 * This class is used to create an object with the information of connection
 * populated here and to create a new session on a DB.
 * 
 * @author andres.vaninetti
 *
 */
public class ConnectionData {

	private String username;
	private String password;
	private String host;

	public ConnectionData(String user, String password, String host) {
		this.username = user;
		this.password = password;
		this.host = host;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getHost() {
		return this.host;
	}

	/**
	 * Create a session with the DB.
	 * 
	 * @throws SQLException
	 */
	public void doDBConnection() {
		System.out.println("Connection established for: " + this.username);	
	}

}
