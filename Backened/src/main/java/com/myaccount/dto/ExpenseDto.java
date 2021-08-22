package com.myaccount.dto;

import java.util.Date;

import com.myaccount.entities.Expense;

public class ExpenseDto {
	private Long expenseId;
	private String expenseAccount;
	private Long expenseCategoryId;
	private float amount;
	private Date transDate;
	private String receiveMode; // B for , C for Cash
	private String remark;
	private Long userId;

	public ExpenseDto() {
		super();
		expenseAccount = new String();
		remark = new String();
	}

	public ExpenseDto(Long expenseId, String expenseAccount, Long expenseCategoryId, float amount, Date transDate,
			String receiveMode, String remark, Long userId) {
		super();
		this.expenseId = expenseId;
		this.expenseAccount = expenseAccount;
		this.expenseCategoryId = expenseCategoryId;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
		this.userId = userId;
	}

	
	public ExpenseDto(Long expenseId, String expenseAccount, Long expenseCategoryId, float amount, Date transDate,
			String receiveMode, String remark) {
		super();
		this.expenseId = expenseId;
		this.expenseAccount = expenseAccount;
		this.expenseCategoryId = expenseCategoryId;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
	}
	

	
	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpenseAccount() {
		return expenseAccount;
	}

	public void setExpenseAccount(String expenseAccount) {
		this.expenseAccount = expenseAccount;
	}

	public Long getExpenseCategoryId() {
		return expenseCategoryId;
	}

	public void setExpenseCategoryId(Long expenseCategoryId) {
		this.expenseCategoryId = expenseCategoryId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getReceiveMode() {
		return receiveMode;
	}

	public void setReceiveMode(String receiveMode) {
		this.receiveMode = receiveMode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Expense getExpense() {
		return new Expense(expenseId, expenseAccount, null, amount, transDate, receiveMode, remark, userId);
	}

	@Override
	public String toString() {
		return "ExpenseDto [expenseId=" + expenseId + ", expenseAccount=" + expenseAccount + ", expenseCategoryId="
				+ expenseCategoryId + ", amount=" + amount + ", transDate=" + transDate + ", receiveMode=" + receiveMode
				+ ", remark=" + remark + ", userId=" + userId + "]";
	}

	

	

}
