package com.austin.projectOne.app;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austin.projectOne.dao.ReimbursementDAO;
import com.austin.projectOne.dao.EmployeeDAO;
import com.austin.projectOne.model.Reimbursement;
import com.austin.projectOne.model.Employee;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class App {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7090);

		Logger logger = LoggerFactory.getLogger(App.class);

		app.get("/index", ctx -> ctx.redirect("index.html"));

		List<Employee> employees = EmployeeDAO.readAll();

		app.get("/employees", ctx -> ctx.jsonStream(employees));

		app.get("/employees/{eid}", ctx -> {
			int eid = Integer.parseInt(ctx.pathParam("eid"));
			Employee employee = EmployeeDAO.readById(eid);
			ctx.json(employee);
		});

		app.post("employees", ctx -> {
			Employee employee = ctx.bodyAsClass(Employee.class);
			//logger.info("This the student object from postman :" + employee);
			EmployeeDAO.save(employee);
			ctx.status(201);
			ctx.redirect("employees.html");
		});

		app.get("employeeForm", ctx -> ctx.redirect("addEmployee.html"));

		/*
	 	private int eid;
		private String email;
		private String password;
		private String name;

	 * 
	 */
		
		app.post("/employeeForm", ctx -> {

			String email = ctx.formParam("email");
			String password = ctx.formParam("password");
			String name = ctx.formParam("name");
			Employee employee = new Employee(email, password, name);
			
			//logger.info("This the student object from postman :" + stu);
			EmployeeDAO.save(employee);
			ctx.status(201);
			ctx.redirect("employees.html");
		});

		app.put("employees/{eid}", ctx -> {
			int eid = Integer.parseInt(ctx.pathParam("eid"));
			Employee employee = ctx.bodyAsClass(Employee.class);
			EmployeeDAO.update(eid, employee);
			ctx.status(200);
			ctx.redirect("employees.html");
		});

		app.delete("employees/{eid}", ctx -> {
			int eid = Integer.parseInt(ctx.pathParam("eid"));
			EmployeeDAO.delete(eid);
			ctx.status(200);
			ctx.redirect("employees.html");
		});

		List<Reimbursement> reimbursements = ReimbursementDAO.findAll();

		
		/*
		private int riembursement_id;
		private String riembursementCategory;
		private Double amount;
		*/
		
		
		app.get("/reimbursement", ctx -> ctx.jsonStream(reimbursements));

		app.get("/reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Reimbursement reimbursement = ReimbursementDAO.findById(id);
			ctx.json(reimbursement);
		});

		app.post("reimbursement", ctx -> {
			Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
//			logger.info("This the student object from postman :" + employee);
			ReimbursementDAO.save(reimbursement);
			ctx.status(201);
			ctx.redirect("reimbursement.html");
		});
		
		app.get("reimbursementForm", ctx -> ctx.redirect("addReimbursement.html"));

		app.post("reimbursementForm", ctx -> {

			String reimbursementCategory = ctx.formParam("reimbursementCategory");
			Double amount = Double.parseDouble(ctx.formParam("amount"));
			
	
			Reimbursement reimbursement = new Reimbursement(reimbursementCategory, amount);
			//logger.info("This the Course object from postman :" + course);
			ReimbursementDAO.save(reimbursement);
			ctx.status(201);
			ctx.redirect("reimbursement.html");
		});

		app.put("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
			ReimbursementDAO.update(id, reimbursement);
			ctx.status(200);
			ctx.redirect("reimbursement.html");
		});

		app.delete("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			ReimbursementDAO.delete(id);
			ctx.status(200);
			ctx.redirect("reimbursement.html");
		});

	}

}
