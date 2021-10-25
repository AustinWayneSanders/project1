//package com.revature.project.service;
//
//import javax.inject.Inject;
//
//import com.revature.project.dao.UserDAO;
//
//public class UserServiceImp {
//
//	
//	@Inject
//	private UserDAO uDao;
//	private static UserDAO uDao = UserDAOImp.getuDao();
//
//	private UserServiceImp() {
//		super();
//	}
//
//	public static UserService getUserv() {
//		if (uServ == null)
//			uServ = new UserServiceImp();
//
//		return uServ;
//	};
//	
//}
