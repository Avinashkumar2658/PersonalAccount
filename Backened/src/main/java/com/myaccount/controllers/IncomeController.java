package com.myaccount.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.myaccount.dto.IncomeDto;
import com.myaccount.entities.Income;
import com.myaccount.entities.IncomeCategory;
import com.myaccount.services.IncomeCategoryService;
import com.myaccount.services.IncomeService;

@CrossOrigin("http://localhost:4200")
@RestController
public class IncomeController {

	@Autowired
	IncomeService incomeService;

	
	@Autowired
	IncomeCategoryService incomeCategoryService;

	@GetMapping("/incomes")
	public List<Income> findAllIncomes() {
		return incomeService.findAllIncomes();
	}

	@GetMapping("/incomes/{incomeId}")
	public ResponseEntity<?> findByIncomeId(@PathVariable Long incomeId) {
		Optional<Income> optionalCategory = incomeService.findIncomeById(incomeId);
		if (optionalCategory.isPresent())
			return new ResponseEntity<Income>(optionalCategory.get(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Income Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/incomes/{incomeId}")
	public ResponseEntity<?> deleteByIncomeId(@PathVariable Long incomeId) {
		incomeService.deleteIncome(incomeId);
		return new ResponseEntity<String>("Income Deleted Successfully", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/incomes")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public ResponseEntity<?> createCategory(@RequestBody IncomeDto incomeDto) throws ParseException {
		SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
		String transdate = formaDate.format(incomeDto.getTransDate());
		incomeDto.setTransDate(formaDate.parse(transdate));
		Income income = incomeDto.getIncome();
		Optional<IncomeCategory> incomeCategory = incomeCategoryService
				.findCategoryById(incomeDto.getIncomeCategoryId());
		income.setIncomeCategory(incomeCategory.get());
		incomeService.createIncome(income);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/incomes/{incomeId}")
	public ResponseEntity<?> updateCategory(@RequestBody IncomeDto incomeDto) {
		Income income = incomeDto.getIncome();
		Optional<IncomeCategory> incomeCategory = incomeCategoryService
				.findCategoryById(incomeDto.getIncomeCategoryId());
		income.setIncomeCategory(incomeCategory.get());
		income = incomeService.updateIncome(income);
		return new ResponseEntity<Income>(income, HttpStatus.OK);
	}
}
