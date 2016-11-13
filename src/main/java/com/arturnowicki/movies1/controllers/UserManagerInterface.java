package com.arturnowicki.movies1.controllers;

import java.sql.SQLException;
import java.util.List;

import com.arturnowicki.movies1.database.data.User;

public interface UserManagerInterface {

	public List<User> searchForUser(String phrase) throws SQLException;
	
	public void saveOrUpdate(User user) throws SQLException;
	
	public void delete(int userId) throws SQLException;
	
	public User getUser(int userId)throws SQLException;
	
	public List<User> getUsersList() throws SQLException;
}
