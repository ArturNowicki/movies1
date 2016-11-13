package com.arturnowicki.movies1.database;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.arturnowicki.movies1.database.data.User;
import com.arturnowicki.movies1.resources.Strings;

public class UserManagerTest {

	private Connection connection;

	@Before
	public void setUp() throws SQLException {
		connection = DatabaseConnector.getInstance().getConnection(Strings.URL, Strings.userName, Strings.pass);
	}

	@After
	public void cleanStream() throws SQLException {
		DatabaseConnector.getInstance().closeDBConnection(connection);
	}

	@Test
	public void testSearchForUser() throws SQLException {
		UserManager userManager = new UserManager(connection);
		List<User> users = userManager.getUsersList();
		users.forEach(System.out::println);
		users = userManager.searchForUser("Wilk");
		users.forEach(System.out::println);
	}

	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws SQLException {
		UserManager userManager = new UserManager(connection);
		List<User> users = userManager.getUsersList();
		users.forEach(System.out::println);
		userManager.delete(4);
		users = userManager.getUsersList();
		users.forEach(System.out::println);
	}

	@Test
	public void testGetUser() throws SQLException {
		UserManager userManager = new UserManager(connection);
		User user = userManager.getUser(4);
		System.out.println(user);
	}

	@Test
	public void testGetUsersList() throws SQLException {
		UserManager userManager = new UserManager(connection);
		List<User> users = userManager.getUsersList();
		users.forEach(System.out::println);
	}

}
