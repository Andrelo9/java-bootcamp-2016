package com.globant.finalproject.daos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.globant.finalproject.entities.User;


@Component
public class UserDAOImplementation implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public UserDAOImplementation() {
		
	}
	

	@Override
	public void userRegistration(int userID, String userNickName, String firstName, String lastName, String password, String eMail) throws SQLException {
		String query = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)";				
		this.jdbcTemplate.update(query, userID, userNickName, firstName , lastName, password, eMail);
	}

	@Override
	public List<User> getUser(int id) {
		String query = "SELECT * FROM users WHERE user_id = ?";		
		return this.jdbcTemplate.query(query, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));		
	}

	@Override
	public void deleteUser(int id) {
		String query = "DELETE FROM users WHERE user_id = ?";
		this.jdbcTemplate.update(query, id);
	}

	@Override
	public List<User> getAllUsers() {
		String query = "SELECT * FROM users";
		return this.jdbcTemplate.query(query, new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
	}

}
