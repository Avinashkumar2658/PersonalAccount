package com.myaccount.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccount.entities.ExpenseCategory;


public interface ExpenseCategoryDao extends JpaRepository<ExpenseCategory, Long> {
	public List<ExpenseCategory> findAllByUserId(Long userId);
}
