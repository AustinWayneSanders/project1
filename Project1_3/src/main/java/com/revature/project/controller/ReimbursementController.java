package com.revature.project.controller;



import com.google.gson.Gson;
import com.revature.project.model.Reimbursement;
import com.revature.project.service.ReimbursementService;
import com.revature.project.service.ReimbursementServiceImp;

import io.javalin.http.Handler;

public class ReimbursementController {

	
	
	private static ReimbursementService rserv = ReimbursementServiceImp.getRserv();
	private static Gson gson = new Gson();
	private static Reimbursement reimbursement = new Reimbursement();
	
	public static Handler createReimbursement = (ctx) -> {
		
		reimbursement.setUserId(Integer.parseInt(ctx.queryParam("userId")));
		reimbursement.setStatus(ctx.queryParam("status")); 
		reimbursement.setEmployeeComments(ctx.queryParam("employeeComments"));
		reimbursement.setAmountRequested(Double.parseDouble(ctx.queryParam("amountRequested")));
		
		try {
				rserv.createReimbursement(reimbursement);
				ctx.status(200);
		} catch (Exception e) {
			ctx.status(404);
			e.printStackTrace();
		}

	};

	
	
}
