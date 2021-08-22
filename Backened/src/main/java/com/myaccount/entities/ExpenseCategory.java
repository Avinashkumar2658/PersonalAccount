package com.myaccount.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "expenses_category")
public class ExpenseCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "expense_category_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long expenseCategoryId;
	private String expenseCategoryName;
	private String expenseCategoryDetails;
	private Long userId;

	public ExpenseCategory() {
		super();

	}

	public ExpenseCategory(Long expenseCategoryId, String expenseCategoryName, String expenseCategoryDetails,
			Long userId) {
		super();
		this.expenseCategoryId = expenseCategoryId;
		this.expenseCategoryName = expenseCategoryName;
		this.expenseCategoryDetails = expenseCategoryDetails;
		this.userId = userId;
	}

	public Long getExpenseCategoryId() {
		return expenseCategoryId;
	}

	public void setExpenseCategoryId(Long expenseCategoryId) {
		this.expenseCategoryId = expenseCategoryId;
	}

	public String getExpenseCategoryName() {
		return expenseCategoryName;
	}

	public void setExpenseCategoryName(String expenseCategoryName) {
		this.expenseCategoryName = expenseCategoryName;
	}

	public String getExpenseCategoryDetails() {
		return expenseCategoryDetails;
	}

	public void setExpenseCategoryDetails(String expenseCategoryDetails) {
		this.expenseCategoryDetails = expenseCategoryDetails;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ExpensesCategory [expenseCategoryId=" + expenseCategoryId + ", expenseCategoryName="
				+ expenseCategoryName + ", expenseCategoryDetails=" + expenseCategoryDetails + ", userId=" + userId
				+ "]";
	}

}
