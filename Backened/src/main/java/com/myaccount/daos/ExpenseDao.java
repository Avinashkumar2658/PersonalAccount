package com.myaccount.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccount.entities.Expense;

public interface ExpenseDao extends JpaRepository<Expense, Long> {
	
}
