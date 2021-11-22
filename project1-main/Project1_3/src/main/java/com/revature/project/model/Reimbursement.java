package com.revature.project.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="reimbursement_id")
	private int reimbursementId;
	@Column(name="user_id")
	private int userId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="reimbursement_id")
	private List<ListItem> listItems;
	@Column(name="status")
	private String status; 
	@Column(name="decision_reasoning")
	private String decisionReasoning;
	@Column(name="employee_comments")
	private String employeeComments;
	@Column(name="submitDate")
	private Date submitDate;
	@Column(name="amount_requested")
	private double amountRequested;
	@Column(name="amount_approved")
	private double amountApproved;
	
	public Reimbursement() {
		super();
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<ListItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDecisionReasoning() {
		return decisionReasoning;
	}

	public void setDecisionReasoning(String decisionReasoning) {
		this.decisionReasoning = decisionReasoning;
	}

	public String getEmployeeComments() {
		return employeeComments;
	}

	public void setEmployeeComments(String employeeComments) {
		this.employeeComments = employeeComments;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}

	public double getAmountApproved() {
		return amountApproved;
	}

	public void setAmountApproved(double amountApproved) {
		this.amountApproved = amountApproved;
	}

	
}
