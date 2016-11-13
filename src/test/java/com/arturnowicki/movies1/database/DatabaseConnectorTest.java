package com.arturnowicki.movies1.database;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.arturnowicki.movies1.resources.Strings;

public class DatabaseConnectorTest {
	
	@Test
	public void testGetConnection() throws SQLException {
		DatabaseConnector connector = DatabaseConnector.getInstance();
		Connection connection = connector.getConnection(Strings.URL, Strings.userName, Strings.pass);
		assertTrue(connection.isValid(10));
	}

	@Test(expected=SQLException.class)
	public void testGetConnectionError() throws SQLException {
		DatabaseConnector connector = DatabaseConnector.getInstance();
		Connection connection = connector.getConnection(Strings.URL, "wrongUserName", Strings.pass);
	}

	@Test
	public void testCloseDBConnection() throws SQLException {
		DatabaseConnector connector = DatabaseConnector.getInstance();
		Connection connection = connector.getConnection(Strings.URL, Strings.userName, Strings.pass);
		connector.closeDBConnection(connection);
		assertTrue(connection.isClosed());
	}

}
