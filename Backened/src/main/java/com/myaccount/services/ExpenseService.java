package com.myaccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.ExpenseDao;
import com.myaccount.entities.Expense;

@Service
public class ExpenseService {
	@Autowired
	ExpenseDao expenseDao;
	
	@Autowired
	UserService userService;

	public Long createExpense(Expense expense ) {
		Long userId = expense.getUserId();
		float expenseAmount = expense.getAmount();
		List<Object> totalAmount = userService.findNetAmountByUserId(userId);
		float r = (float) totalAmount.get(0);
		float netAmount = (float) (r   - expenseAmount);
		userService.updateAmount(userId, netAmount);
		expense = expenseDao.save(expense);
		return expense.getExpenseId();
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseDao.save(expense);
	}
	public void deleteExpense(Long expenseId) {
		expenseDao.deleteById(expenseId);
	}
	
	public Optional<Expense> findExpenseById(Long expenseId) {
		return expenseDao.findById(expenseId);
	}
	
	public List<Expense> findAllExpense() {
		return expenseDao.findAll();
	}
	
}
