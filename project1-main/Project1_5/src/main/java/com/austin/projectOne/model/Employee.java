package com.austin.projectOne.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String email;
	private String password;
	private String name;
	
	public Employee() {
		super();
	}

	public Employee(int eid, String email, String password, String name) {
		super();
		this.eid = eid;
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	
	public Employee(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name; 
	}


	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}

	
	
	
}