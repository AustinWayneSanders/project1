package com.revature.project.service;

import java.util.List;

import com.revature.project.model.Reimbursement;
import com.revature.project.model.User;

public interface ReimbursementService {

	// CRUD
	Reimbursement createReimbursement(Reimbursement reimbursement);

	// GET ALL USERS 
	
	List<User> getAllUsers();
	
	// READ
	Reimbursement getReimbursementById(int rid);

	// ALL
	List<Reimbursement> getAllReimbursement();

	// EMPLOYEE
	List<Reimbursement> getReimbursementByEmployee(int eid);

	// CATEGORY
	List<Reimbursement> getReimbursementByCategory(int cid);

	// MANAGER
	List<Reimbursement> getReimbursementByManager(int mgid);

//	    Get By STATUS
	List<Reimbursement> getReimbursementsApproved();

	List<Reimbursement> getReimbursementsDenied();

//	    Sort By AMOUNT
	List<Reimbursement> getReimbursementsAmountAscending();

	List<Reimbursement> getReimbursementsAmountDescending();

//	    Sort By STATUS_DATE
	List<Reimbursement> getReimbursementsStatusDateAscending();

	List<Reimbursement> getReimbursementsStatusDateDescending();

//	    Sort By SUBMIT_DATE
	List<Reimbursement> getReimbursementsSubmitDateAscending();

	List<Reimbursement> getReimbursementsSubmitDateDescending();

//	    Update
	Reimbursement updateReimbursement(Reimbursement reimbursement);

//	    Delete
	boolean deleteReimbursement(Reimbursement reimbursement);
}
