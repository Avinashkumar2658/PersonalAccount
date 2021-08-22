package com.myaccount.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "income_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long incomecId;
	private String incomeAccount;
	@ManyToOne
	@JoinColumn(name = "income_category_id", referencedColumnName = "incomeCategoryId")
	private IncomeCategory incomeCategory;
	private float amount;
	@Temporal(TemporalType.DATE)
	private Date transDate;
	private String receiveMode; // B for , C for Cash
	private String remark;
	private Long userId;

	public Income() {
		super();
	}


	

	public Income(Long incomecId, String incomeAccount, IncomeCategory incomeCategory, float amount, Date transDate,
			String receiveMode, String remark, Long userId) {
		super();
		this.incomecId = incomecId;
		this.incomeAccount = incomeAccount;
		this.incomeCategory = incomeCategory;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
		this.userId = userId;
	}




	public Income(Long incomecId, String incomeAccount, IncomeCategory incomeCategory, float amount, float tAmount,
			Date transDate, String receiveMode, String remark, Long userId) {
		super();
		this.incomecId = incomecId;
		this.incomeAccount = incomeAccount;
		this.incomeCategory = incomeCategory;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
		this.userId = userId;
	}

	public Long getIncomeId() {
		return incomecId;
	}

	public void setIncomeId(Long incomeId) {
		this.incomecId = incomeId;
	}

	public String getIncomeAccount() {
		return incomeAccount;
	}

	public void setIncomeAccount(String incomeAccount) {
		this.incomeAccount = incomeAccount;
	}

	public IncomeCategory getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(IncomeCategory incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Long getIncomecId() {
		return incomecId;
	}

	public void setIncomecId(Long incomecId) {
		this.incomecId = incomecId;
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
		return "Income [incomecId=" + incomecId + ", incomeAccount=" + incomeAccount + ", incomeCategory="
				+ incomeCategory + ", amount=" + amount + ", transDate=" + transDate + ", receiveMode=" + receiveMode
				+ ", remark=" + remark + ", userId=" + userId + "]";
	}

}
