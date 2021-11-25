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
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7090);

		Logger logger = LoggerFactory.getLogger(App.class);

		//app.get("/login", ctx -> ctx.redirect("login.html"));

		
		
		app.get("/login", ctx -> {
			String email  = ctx.queryParam("email");
			System.out.print(email);
			String password = ctx.queryParam("password");
			System.out.print(password);
			long count = EmployeeDAO.findByCredentials(email, password);
			System.out.print(count);
			if (count == 1) {
				ctx.status(200);
				ctx.redirect("index.html");
				
			}else {
				ctx.redirect("login.html");
			}
			
			
					
		});
		
		
		app.get("/employees", ctx -> {
			List<Employee> employees = EmployeeDAO.findAll();
			ctx.jsonStream(employees);
		});

		app.get("/employee/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Employee employee = EmployeeDAO.findById(id);
			ctx.json(employee);
		});

		app.post("employee", ctx -> {
			Employee employee = ctx.bodyAsClass(Employee.class);
			logger.info("This the Employee object from postman :" + employee);
			EmployeeDAO.save(employee);
			ctx.status(201);
//ctx.redirect("reimbursement.html");
		});

		app.get("employeeForm", ctx -> ctx.redirect("addEmployee.html"));

		app.post("employeeForm", ctx -> {

			String email = ctx.formParam("email");
			String password = ctx.formParam("password");
			String name = ctx.formParam("name");

			Employee employee = new Employee(email, password, name);
			logger.info("This the Employee object from postman :" + employee);
			EmployeeDAO.save(employee);
			ctx.status(201);
			ctx.redirect("employees.html");
		});

		app.put("employee/{eid}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("eid"));
			Employee employee = ctx.bodyAsClass(Employee.class);
			employee.setEid(id);
			EmployeeDAO.update(employee);
			ctx.status(200);
//ctx.redirect("reimbursement.html");
		});

		app.delete("employee/{eid}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("eid"));
			EmployeeDAO.delete(id);
			ctx.status(200);
//ctx.redirect("reimbursement.html");
		});

	

		app.get("/reimbursement", ctx -> {
			List<Reimbursement> reimbursements = ReimbursementDAO.findAll();
			ctx.jsonStream(reimbursements);
		});

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
			// ctx.redirect("reimbursement.html");
		});

		app.get("reimbursementForm", ctx -> ctx.redirect("addReimbursement.html"));

		app.post("reimbursementForm", ctx -> {

			String reimbursementCategory = ctx.formParam("reimbursementCategory");
			Double amount = Double.parseDouble(ctx.formParam("amount"));
			String status = "pending";

			Reimbursement reimbursement = new Reimbursement(reimbursementCategory, amount, status);
			logger.info("This the Reimbursement object from postman :" + reimbursement);
			ReimbursementDAO.save(reimbursement);
			ctx.status(201);
			ctx.redirect("reimbursement.html");
		});

		app.put("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
			reimbursement.setId(id);
			ReimbursementDAO.update(reimbursement);
			ctx.status(200);
			// ctx.redirect("reimbursement.html");
		});

		app.delete("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			ReimbursementDAO.delete(id);
			ctx.status(200);
			// ctx.redirect("reimbursement.html");
		});

	}
}
