package com.myaccount.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myaccount.entities.ExpenseCategory;
import com.myaccount.services.ExpenseCategoryService;

@CrossOrigin("http://localhost:4200")
@RestController
public class ExpensesCategoryController {

	@Autowired
	ExpenseCategoryService expenseCategoryService;

	@GetMapping("/expensecategories")
	public List<ExpenseCategory> findAllCategories() {
		return expenseCategoryService.findAllCategories();
	}

	@GetMapping("/users/{userId}/expensecategories")
	public List<ExpenseCategory> findAllCategoriesByUserId(@PathVariable Long userId) {
		return expenseCategoryService.findAllCategories(userId);
	}

	@GetMapping("/expensecategories/{expenseCategoryId}")
	public ResponseEntity<?> findByCategoryId(@PathVariable Long expenseCategoryId) {
		Optional<ExpenseCategory> optionalCategory = expenseCategoryService.findCategoryById(expenseCategoryId);
		if (optionalCategory.isPresent())
			return new ResponseEntity<ExpenseCategory>(optionalCategory.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Income Category Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/expensecategories/{expenseCategoryId}")
	public ResponseEntity<?> deleteByCategoryId(@PathVariable Long expenseCategoryId) {
		expenseCategoryService.deleteCategory(expenseCategoryId);
		return new ResponseEntity<String>("Income Category Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/expensecategories/")
	public ResponseEntity<?> createCategory(@RequestBody ExpenseCategory category) {
		expenseCategoryService.createCategory(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/expensecategories/{expenseCategoryId}")
	public ResponseEntity<?> updateCategory(@RequestBody ExpenseCategory category) {
		category = expenseCategoryService.updateCategory(category);
		return new ResponseEntity<ExpenseCategory>(category, HttpStatus.OK);
	}

}
