package com.revature.project.service;

import java.util.List;

import com.revature.project.model.Reimbursement;
import com.revature.project.model.User;
import com.revature.project.dao.ReimbursementDAO;

import com.revature.project.dao.ReimbursementDAOImp;


public class ReimbursementServiceImp implements ReimbursementService{

	
	private static ReimbursementDAO rdao = ReimbursementDAOImp.getRdao();
	//private static UserService userService = userServiceImp.getUserv();
	private static ReimbursementService rserv;

	private ReimbursementServiceImp() {
	}

	public static ReimbursementService getRserv() {
		if (rserv == null)
			rserv = new ReimbursementServiceImp();
		return rserv;
	}
	
		
	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		return rdao.createReimbursement(reimbursement);
	}

	@Override
	public List<User> getAllUsers() {
		return rdao.getAllUsers();
	}

	@Override
	public Reimbursement getReimbursementById(int rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByEmployee(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByCategory(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByManager(int mgid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsDenied() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsAmountAscending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsAmountDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsStatusDateAscending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsStatusDateDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsSubmitDateAscending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementsSubmitDateDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
