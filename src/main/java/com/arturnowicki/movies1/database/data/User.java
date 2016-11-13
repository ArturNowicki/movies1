package com.arturnowicki.movies1.database.data;

public class User {
	private Integer userId;
	private String firstName;
	private String lastName;
	private Gender gender;

	public User(String firstName, String secondName, Gender gender) {
		this(-1, firstName, secondName, gender);
	}

	public User(Integer id, String firstName, String secondName, Gender gender) {
		this.userId = id;
		this.firstName = firstName;
		this.lastName = secondName;
		this.gender = gender;
	}

//	getters
	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "User: " + userId + " " + firstName + " " + lastName + " " + gender;
	}
}
