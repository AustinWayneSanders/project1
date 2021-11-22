package com.revature.project.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("manager")

public class Manager extends User{

	@Column(name="department")
	private String department;
	@Column(name="salary")
	private String salary;
	@Column(name = "startDate")
	private String startDate;
	@Column(name = "endDate")
	private String endDate;
	
}
