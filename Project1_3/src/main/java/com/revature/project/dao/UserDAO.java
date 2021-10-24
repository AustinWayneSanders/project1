package com.revature.project.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revature.project.model.User;

public class UserDAO {
	
	private static List<User> users = new ArrayList<User>(Arrays.asList(new User(0, "SteveRogers", "steve@gmail.com", null, 25, "steve"),
			new User(1, "TonyStark", "tony@iron.com", null, 56, "tony"), new User(2, "CarolDanvers", "carol@xmas.com", null, 35, "carol")));

	private static UserDAO userDAO = null;

	private UserDAO() {
	}

	public static UserDAO instance() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

//	public Optional<User> getUserById(int id) {
//		return users.stream().filter(u -> u.getId() == id).findAny();
//	}
//
	
	public Optional<User> getUserById(int id) {
		return users.stream().filter(u -> u.getId() == id).findAny();
	}

	
	public static Iterable<String> getAllUsernames() {
		return users.stream().map(user -> user.getUsername()).collect(Collectors.toList());
	}
//
	public User addUser(User user) {
		users.add(user);
		return user;
	}
}
