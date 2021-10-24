package com.revature.project.controller;

//import java.util.Objects;

//import com.google.gson.Gson;
//import com.revature.dao.UserDAO;
//import com.revature.model.User;

import io.javalin.http.Handler;

import com.google.gson.Gson;
import com.revature.project.dao.UserDAO;
import com.revature.project.model.User;

import java.util.Objects;

//import org.mindrot.jbcrypt.BCrypt;


public class UserController {
	private static Gson gson = new Gson();
	
//	public static boolean authenticate(String username, String password) {
//        if (username == null || password == null) {
//            return false;
//        }
//        User user = UserDAO.getUserByUsername(username);
//        if (user == null) {
//            return false;
//        }
//        
//        return password.equals(password);
//    }
//
//    // This method doesn't do anything, it's just included as an example
//    public static void setPassword(String username, String oldPassword, String newPassword) {
//        if (authenticate(username, oldPassword)) {
//            String newSalt = BCrypt.gensalt();
//            String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
//            // Update the user salt and password
//        }
//    }
	
	
	
//private static Gson gson = new Gson();
	

//	public static Handler fetchAllUsers = ctx -> {
//		UserDAO dao = UserDAO.instance();
//		Iterable<User> allUsers = UserDAO.getAllUsers();
//		ctx.json(allUsers);
//	};
//
////	
//	public static Handler fetchById = ctx -> {
//		int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
//		UserDAO dao = UserDAO.instance();
//		User user = dao.getUserById(id).get();
//		if (user == null) {
//			ctx.html("Not Found");
//		} else {
//			ctx.json(user);
//		}
//	};
//	
//	public static Handler addUser = ctx -> {
//		String body = ctx.body();
//		UserDAO dao = UserDAO.instance();
//		try {
//			User user = gson.fromJson(body, User.class);
//			if (user != null) {
//				User returned = dao.addUser(user);
//				ctx.result(gson.toJson(returned));
//				ctx.status(200);
//			} else
//				ctx.status(404);
//
//		} catch (Exception e) {
//			ctx.status(404);
//			e.printStackTrace();
//		}
//	};

	
	
	
	
	public static Handler fetchAllUsernames = ctx -> {
		UserDAO dao = UserDAO.instance();
		Iterable<String> allUsers = dao.getAllUsernames();
		ctx.json(allUsers);
	};

	public static Handler fetchById = ctx -> {
		int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
		UserDAO dao = UserDAO.instance();
		User user = dao.getUserById(id).get();
		if (user == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(user);
		}
	};
	
	public static Handler addUser = ctx -> {
		String body = ctx.body();
		UserDAO dao = UserDAO.instance();
		try {
			User user = gson.fromJson(body, User.class);
			if (user != null) {
				User returned = dao.addUser(user);
				ctx.result(gson.toJson(returned));
				ctx.status(200);
			} else
				ctx.status(404);

		} catch (Exception e) {
			ctx.status(404);
			e.printStackTrace();
		}
	};
	
	
	
	
	
}
