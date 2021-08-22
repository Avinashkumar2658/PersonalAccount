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

import com.myaccount.dto.ExpenseDto;
import com.myaccount.entities.Expense;
import com.myaccount.entities.ExpenseCategory;
import com.myaccount.services.ExpenseCategoryService;
import com.myaccount.services.ExpenseService;

@CrossOrigin("http://localhost:4200")
@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@Autowired
	ExpenseCategoryService expenseCategoryService;

	@GetMapping("/expenses")
	public List<Expense> findAllIncomes() {
		return expenseService.findAllExpense();
	}
	

	@GetMapping("/expenses/{expenseId}")
	public ResponseEntity<?> findByIncomeId(@PathVariable Long expenseId) {
		Optional<Expense> optionalCategory = expenseService.findExpenseById(expenseId);
		if (optionalCategory.isPresent())
			return new ResponseEntity<Expense>(optionalCategory.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Expense Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/expenses/{expenseId}")
	public ResponseEntity<?> deleteByExpenseId(@PathVariable Long expenseId) {
		expenseService.deleteExpense(expenseId);
		return new ResponseEntity<String>("Expense Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/expense")
	public ResponseEntity<?> createCategory(@RequestBody ExpenseDto expenseDto) {
		Expense expense = expenseDto.getExpense();
		Optional<ExpenseCategory> expenseCategory = expenseCategoryService
				.findCategoryById(expenseDto.getExpenseCategoryId());
		expense.setExpenseCategory(expenseCategory.get());
		expenseService.createExpense(expense);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/expenses/{expenseId}")
	public ResponseEntity<?> updateCategory(@RequestBody ExpenseDto expenseDto) {
		Expense expense = expenseDto.getExpense();
		Optional<ExpenseCategory> expenseCategory = expenseCategoryService
				.findCategoryById(expenseDto.getExpenseCategoryId());
		expense.setExpenseCategory(expenseCategory.get());
		expense = expenseService.updateExpense(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
}
