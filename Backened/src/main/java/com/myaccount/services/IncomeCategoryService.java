package com.myaccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.IncomeCategoryDao;
import com.myaccount.entities.IncomeCategory;

@Service
public class IncomeCategoryService {

	@Autowired
	IncomeCategoryDao categoryDao;

	public Long createCategory(IncomeCategory category) {
		category = categoryDao.save(category);
		return category.getIncomeCategoryId();
	}

	public IncomeCategory updateCategory(IncomeCategory category) {
		return categoryDao.save(category);
	}

	public void deleteCategory(Long categoryId) {
		categoryDao.deleteById(categoryId);
	}

	public Optional<IncomeCategory> findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId);
	}

	public List<IncomeCategory> findAllCategoreis() {
		return categoryDao.findAll();
	}

	public List<IncomeCategory> findAllCategoreis(Long userId) {
		return categoryDao.findAllByUserId(userId);
	}
	
	

}
