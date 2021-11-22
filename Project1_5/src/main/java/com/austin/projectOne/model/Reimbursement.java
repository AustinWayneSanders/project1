//Reimbursement_Entity_Bean


package com.austin.projectOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reimbursementCategory;
	private Double  amount;	
	private String status;

	public Reimbursement() {
		super();
	}

	public Reimbursement(String reimbursementCategory, Double amount, String status) {
		super();
		this.reimbursementCategory = reimbursementCategory;
		this.amount = amount;
		this.status = status;
	}

	public Reimbursement(int id, String name, String reimbursementCategory, Double amount, String status) {
		super();
		this.id = id;
		this.reimbursementCategory = reimbursementCategory;
		this.amount = amount;
		
		this.status = status;
	}

	public int getId() {
		return id;
	} 

	public void setId(int id) {
		this.id = id;
	}

	public String getReimbursementCategory() {
		return reimbursementCategory;
	}

	public void setReimbursementCategory (String reimbursementCategory) {
		this.reimbursementCategory = reimbursementCategory;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {  
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
