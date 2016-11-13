package com.arturnowicki.movies1.database.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setupStream() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanStream() {
		System.setOut(null);
	}
	
	@Test
	public void testFullConstructor() {
		User user = new User(4, "Artur", "Nowicki", Gender.M);
		assertEquals(4, user.getUserId());
	}

	@Test
	public void testToString() {
		String userString = "User: Artur Nowicki";
		User user = new User("Artur", "Nowicki", Gender.M);
		System.out.print(user);
		assertEquals(userString, outContent.toString());
	}

	@Test
	public void testGetFirstName() {
		User user = new User("Artur", "Nowicki", Gender.M);
		assertEquals("Artur", user.getFirstName());
	}

	@Test
	public void testGetSecondName() {
		User user = new User("Artur", "Nowicki", Gender.M);
		assertEquals("Nowicki", user.getLastName());
	}

	@Test
	public void testGetGender() {
		User user = new User("Artur", "Nowicki", Gender.M);
		assertEquals(Gender.M, user.getGender());
	}

}
