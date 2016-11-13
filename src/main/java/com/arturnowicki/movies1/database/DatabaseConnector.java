package com.arturnowicki.movies1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	private static final DatabaseConnector instance = new DatabaseConnector();
	private Connection connection = null;

	public static DatabaseConnector getInstance() {
		return instance;
	}

	public Connection getConnection(String URL, String userName, String pass) throws SQLException {
		connection = DriverManager.getConnection(URL, userName, pass);
		return connection;
	}

	public void closeDBConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
