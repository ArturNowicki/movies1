package com.arturnowicki.movies1.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arturnowicki.movies1.controllers.UserManagerInterface;
import com.arturnowicki.movies1.database.data.Gender;
import com.arturnowicki.movies1.database.data.User;

public class UserManager implements UserManagerInterface {

	private Connection connection;
	private String dbName = "movies";
	private String tableName = "user";
	private String fullTableName = dbName + "." + tableName;
	
	public UserManager(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<User> searchForUser(String phrase) throws SQLException {
		List<User> users = new ArrayList<>();
		String checkSql = "SELECT * FROM " + fullTableName + " WHERE ? in (first_name, last_name, gender)";
		PreparedStatement statement = connection.prepareStatement(checkSql);
		statement.setString(1, phrase);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Gender.valueOf(resultSet.getString(4))));
		}
		statement.close();
		return users;
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int userId) throws SQLException {
		String checkSql = "DELETE FROM " + fullTableName + " WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(checkSql);
		statement.setInt(1, userId);
		statement.executeUpdate();
		statement.close();
	}

	@Override
	public User getUser(int userId) throws SQLException {
		String checkSql = "SELECT * FROM " + fullTableName + " WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(checkSql);
		statement.setInt(1, userId);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Gender.valueOf(resultSet.getString(4)));
		statement.close();
		return user;
	}

	@Override
	public List<User> getUsersList() throws SQLException {
		List<User> users = new ArrayList<>();
		String checkSql = "SELECT * FROM " + fullTableName + " ORDER BY id";
		PreparedStatement statement = connection.prepareStatement(checkSql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Gender.valueOf(resultSet.getString(4))));
		}
		statement.close();
		return users;
	}

}
