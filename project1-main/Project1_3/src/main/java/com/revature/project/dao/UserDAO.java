package com.revature.project.dao;

import com.revature.project.model.User;



public interface UserDAO {
	
	
	User getUserByIdFromEmail(String email);
	
	
	
}
