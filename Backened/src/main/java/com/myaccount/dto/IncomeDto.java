package com.myaccount.dto;

import java.util.Date;

import com.myaccount.entities.Income;

public class IncomeDto {

	private Long incomeId;
	private String incomeAccount;
	private Long incomeCategoryId;
	private float amount;
	private Date transDate;
	private String receiveMode; // B for , C for Cash
	private String remark;
	private Long userId;

	public IncomeDto() {
		super();
	}

	public IncomeDto(Long incomeId, String incomeAccount, Long incomeCategoryId, float amount, Date transDate,
			String receiveMode, String remark, Long userId) {
		super();
		this.incomeId = incomeId;
		this.incomeAccount = incomeAccount;
		this.incomeCategoryId = incomeCategoryId;
		this.amount = amount;
		this.transDate = transDate;
		this.receiveMode = receiveMode;
		this.remark = remark;
		this.userId = userId;
	}

	public Long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeAccount() {
		return incomeAccount;
	}

	public void setIncomeAccount(String incomeAccount) {
		this.incomeAccount = incomeAccount;
	}

	public Long getIncomeCategoryId() {
		return incomeCategoryId;
	}

	public void setIncomeCategoryId(Long incomeCategoryId) {
		this.incomeCategoryId = incomeCategoryId;
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

	public Income getIncome() {
		return new Income(incomeId, incomeAccount, null, amount, transDate, receiveMode, remark, userId);
	}

	@Override
	public String toString() {
		return "IncomeDto [incomeId=" + incomeId + ", incomeAccount=" + incomeAccount + ", incomeCategoryId="
				+ incomeCategoryId + ", amount=" + amount + ", transDate=" + transDate + ", receiveMode=" + receiveMode
				+ ", remark=" + remark + ", userId=" + userId + "]";
	}

}
