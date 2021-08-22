package com.myaccount.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "expenses_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long expenseId;
	private String expenseAccount;
	@ManyToOne
	@JoinColumn(name = "expense_category_id", referencedColumnName = "expenseCategoryId")
	private ExpenseCategory expenseCategory;
	private float amount;
	@Temporal(TemporalType.DATE)
	private Date transDate;
	private String receiveMode; // B for , C for Cash
	private String remark;
	private Long userId;

	public Expense() {
		super();

	}

	public Expense(Long expenseId, String expenseAccount, ExpenseCategory expenseCategory, float amount, Date transDate,
			String receiveMode, String remark, Long userId) {
		super();
		this.expenseId = expenseId;
		this.expenseAccount = expenseAccount;
		this.expenseCategory = expenseCategory;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
		this.userId = userId;
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

	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
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

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", expenseAccount=" + expenseAccount + ", expenseCategory="
				+ expenseCategory + ", amount=" + amount + ", transDate=" + transDate + ", receiveMode=" + receiveMode
				+ ", remark=" + remark + ", userId=" + userId + "]";
	}

}
