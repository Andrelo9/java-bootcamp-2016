package com.globant.topicfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class contains the basic configuration of JDBC interface and perform a querys.
 * 
 * @author andres.vaninetti
 *
 */
public class ConnectionData {

	private String username;
	private String password;
	private String host;
	private Connection connect = null;
	private Statement staetment = null;
	private ResultSet resultSet = null;

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
	
	public Connection getConnection() {
		return this.connect;
	}
	
	public Statement getStatement() {
		return this.staetment;
	}

	/**
	 * Create a MySQL instance using singleton pattern, and execute a query. 
	 * 
	 * @throws SQLException
	 */
	public void doDBConnection() throws SQLException {
		System.out.println("Connection established for: " + this.username);
		this.connect = DriverManager.getConnection(this.host,this.username,this.password);		
		executeQuery();        		
		printResults();	
	}

	/**
	 * Execute a query passed in the parameters. 
	 * 
	 * @throws SQLException
	 */
	private void executeQuery() throws SQLException {
		this.staetment = this.connect.createStatement();
		this.resultSet = this.staetment.executeQuery(
		"SELECT DISTINCT course.course_name AS COURSE, " +
		"teacher.last_name AS TEACHER_LASTNAME, " +
        "teacher.first_name AS TEACHER_FIRSTNAME, " +
        "student.last_name AS STUDENT_LASTNAME, " +
        "student.first_name AS STUDENT_FIRSTNAME " +
        "FROM course " +
        "INNER JOIN inscript ON inscript.course_id = course.course_id " +
        "INNER JOIN teacher ON teacher.teacher_id = course.teacher_id "+
        "INNER JOIN student ON inscript.registration_number = student.registration_number "+ 
        "WHERE inscript.course_id = 101 "+
		"ORDER BY student.last_name;");
		
	}

	/**
	 * Print the query results in the console.
	 * 
	 * @throws SQLException
	 */
	private void printResults() throws SQLException {		
		while(resultSet.next()){
			String course = this.resultSet.getString("course");
			String teacher_lastname = this.resultSet.getString("TEACHER_LASTNAME");
			String teacher_firstname = this.resultSet.getString("TEACHER_FIRSTNAME");
			String student_lastname = this.resultSet.getString("STUDENT_LASTNAME");
			String student_firstname = this.resultSet.getString("STUDENT_FIRSTNAME");
			System.out.println("Course: " + course);
	        System.out.println("Last name: " + teacher_lastname);
	        System.out.println("First name: " + teacher_firstname);
	        System.out.println("Last name: " + student_lastname);
	        System.out.println("First name: " + student_firstname);
		}
	}

}
