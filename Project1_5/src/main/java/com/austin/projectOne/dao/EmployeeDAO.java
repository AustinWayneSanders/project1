package com.austin.projectOne.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 	private int eid;
	private String email;
	private String password;
	private String name;

 * 
 */



import com.austin.projectOne.model.Employee;

public class EmployeeDAO {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static List<Employee> readAll() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "select * from employee";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEid(rs.getInt("eid"));
				employee.setEmail(rs.getString("email"));
				employee.setPassword(rs.getString("password"));
				employee.setName(rs.getString("name"));
			
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return employees;
	}

	public static Employee readById(int eid) {
		Employee employee = new Employee();
		String query = "select * from employee where id=" + eid;
		System.out.print(query);
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				employee.setEid(rs.getInt("eid"));
				employee.setEmail(rs.getString("email"));
				employee.setPassword(rs.getString("password"));
				employee.setName(rs.getString("name"));							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return employee;
	}

	public static void save(Employee employee) {
		String query = "insert into employee (email,password,name) values (?,?,?)";
		System.out.print(query);
		connect();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmail());
			pstmt.setString(2, employee.getPassword());
			pstmt.setString(3, employee.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}
	
	public static void update(int eid, Employee employee) {
		
		String query = "update employee set email=?, password=? name=? where eid=?";
		System.out.print(query);
		connect();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmail());
			pstmt.setString(2, employee.getPassword());
			pstmt.setString(3, employee.getName());
			pstmt.setInt(4, eid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}
	
	public static void delete(int eid) {
		String query = "delete from employee where id="+ eid;
		System.out.print(query);
		connect();
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}

	public static Connection connect() {
		String dbUrl = "jdbc:postgresql://projectonedb.ctc7aq5bma3z.us-east-2.rds.amazonaws.com:5432/postgres";
		try {
			conn = DriverManager.getConnection(dbUrl, "postgres", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {

		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
