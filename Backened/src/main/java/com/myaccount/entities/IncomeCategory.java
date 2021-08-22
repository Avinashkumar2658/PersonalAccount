package com.myaccount.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class IncomeCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "income_category_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long incomeCategoryId;
	private String incomeCategoryName;
	private String incomeCategoryDetails;
	private Long userId;

	public IncomeCategory() {
		super();
	}

	public IncomeCategory(Long incomeCategoryId, String incomeCategoryName, String incomeCategoryDetails) {
		super();
		this.incomeCategoryId = incomeCategoryId;
		this.incomeCategoryName = incomeCategoryName;
		this.incomeCategoryDetails = incomeCategoryDetails;
	}

	public IncomeCategory(Long incomeCategoryId, String incomeCategoryName, String incomeCategoryDetails, Long userId) {
		super();
		this.incomeCategoryId = incomeCategoryId;
		this.incomeCategoryName = incomeCategoryName;
		this.incomeCategoryDetails = incomeCategoryDetails;
		this.userId = userId;
	}

	public Long getIncomeCategoryId() {
		return incomeCategoryId;
	}

	public void setIncomeCategoryId(Long incomeCategoryId) {
		this.incomeCategoryId = incomeCategoryId;
	}

	public String getIncomeCategoryName() {
		return incomeCategoryName;
	}

	public void setIncomeCategoryName(String incomeCategoryName) {
		this.incomeCategoryName = incomeCategoryName;
	}

	public String getIncomeCategoryDetails() {
		return incomeCategoryDetails;
	}

	public void setIncomeCategoryDetails(String incomeCategoryDetails) {
		this.incomeCategoryDetails = incomeCategoryDetails;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "IncomeCategory [incomeCategoryId=" + incomeCategoryId + ", incomeCategoryName=" + incomeCategoryName
				+ ", incomeCategoryDetails=" + incomeCategoryDetails + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incomeCategoryId == null) ? 0 : incomeCategoryId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomeCategory other = (IncomeCategory) obj;
		if (incomeCategoryId == null) {
			if (other.incomeCategoryId != null)
				return false;
		} else if (!incomeCategoryId.equals(other.incomeCategoryId))
			return false;
		return true;
	}

}