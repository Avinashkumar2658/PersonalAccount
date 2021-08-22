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

import com.myaccount.entities.IncomeCategory;
import com.myaccount.services.IncomeCategoryService;

@CrossOrigin("http://localhost:4200")
@RestController
public class IncomeCategoryController {

	@Autowired
	IncomeCategoryService incomeCategoryService;
	@GetMapping("/incomecategories")
	public List<IncomeCategory> findAllCategories() {
		return incomeCategoryService.findAllCategoreis();
	}

	@GetMapping("/users/{userId}/incomecategories")
	public List<IncomeCategory> findAllCategoriesByUserId(@PathVariable Long userId) {
		return incomeCategoryService.findAllCategoreis(userId);
	}

	@GetMapping("/incomecategories/{incomeCategoryId}")
	public ResponseEntity<?> findByCategoryId(@PathVariable Long incomeCategoryId) {
		Optional<IncomeCategory> optionalCategory = incomeCategoryService.findCategoryById(incomeCategoryId);
		if (optionalCategory.isPresent())
			return new ResponseEntity<IncomeCategory>(optionalCategory.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Income Category Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/incomecategories/{incomeCategoryId}")
	public ResponseEntity<?> deleteByCategoryId(@PathVariable Long incomeCategoryId) {
		incomeCategoryService.deleteCategory(incomeCategoryId);
		return new ResponseEntity<String>("Income Category Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/incomecategories/")
	public ResponseEntity<?> createCategory(@RequestBody IncomeCategory category) {
		incomeCategoryService.createCategory(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/incomecategories/{incomeCategoryId}")
	public ResponseEntity<?> updateCategory(@RequestBody IncomeCategory category) {
		category = incomeCategoryService.updateCategory(category);
		return new ResponseEntity<IncomeCategory>(category, HttpStatus.OK);
	}
}
