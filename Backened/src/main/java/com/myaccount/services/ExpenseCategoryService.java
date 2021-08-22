package com.myaccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.ExpenseCategoryDao;
import com.myaccount.entities.ExpenseCategory;


@Service
public class ExpenseCategoryService {

	@Autowired
	ExpenseCategoryDao expenseCategoryDao;
	
	public Long createCategory(ExpenseCategory expenseCategory) {
		expenseCategory = expenseCategoryDao.save(expenseCategory);
		return expenseCategory.getExpenseCategoryId();
	}
	
	public ExpenseCategory updateCategory(ExpenseCategory expenseCategory) {
		return expenseCategoryDao.save(expenseCategory);
	}
	
	public void deleteCategory(Long categoryId) {
		expenseCategoryDao.deleteById(categoryId);
		
	}
	
	public Optional<ExpenseCategory> findCategoryById(Long categoryId) {
		return expenseCategoryDao.findById(categoryId);
	}
	
	public List<ExpenseCategory> findAllCategories() {
		return expenseCategoryDao.findAll();
	}
	
	public List<ExpenseCategory> findAllCategories(Long userId) {
		return expenseCategoryDao.findAllByUserId(userId);
	}
}
