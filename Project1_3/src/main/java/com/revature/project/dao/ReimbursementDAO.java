package com.revature.project.dao;

import java.util.List;

import com.revature.project.model.Reimbursement;
import com.revature.project.model.User;

public interface ReimbursementDAO {

//	CRUD
	Reimbursement createReimbursement(Reimbursement reimbursement);

//	Read
	Reimbursement getReimbursementById(int rid);

	List<Reimbursement> getAllReimbursement();

//	Update
	Reimbursement updateReimbursement(Reimbursement reimbursement);

//	Delete
	boolean deleteReimbursement(Reimbursement reimbursement);

// Get Users to Display on View
	
	List<User> getAllUsers();
	
}
