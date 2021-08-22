package com.myaccount.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myaccount.exceptions.IncomeNotFoundException;
import com.myaccount.services.DayBookService;

@CrossOrigin("http://localhost:4200")
@RestController
public class DayBookController {

	@Autowired
	DayBookService dayBookService;





//	@GetMapping("/income/{startDate}/between/{endDate}")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	public ResponseEntity<?> findByIncomeDayBook( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
//	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date endDate) {
//		Optional<Income[]> optionalCategory = dayBookService.findIncomeByDate(startDate, endDate);
//		if (optionalCategory.isPresent())
//			return new ResponseEntity<Income[]>(optionalCategory.get(), HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Income Not Found", HttpStatus.NOT_FOUND);
//	}


	
	@GetMapping("/incomes/{userId}/{from}/to/{to}")
	public List<List<Object[]>> findByIncomeDayBook(@PathVariable Long userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, 
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		List<List<Object[]>> optionalCategory = dayBookService.findIncomeExpenseByDate(userId, from, to);
		if ( optionalCategory.contains(null) || optionalCategory.isEmpty())
			throw new IncomeNotFoundException("Income Not Found : " + from + "between" + to);
		return optionalCategory;
	}
	
//	@GetMapping("/income/{from}/to/{to}")
//	public List<Object[]> findByExpenseDayBook(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, 
//			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
//		List<Object[]> optionalCategory = dayBookService.findExpenseByDate(from, to);
//		if ( optionalCategory.contains(null) || optionalCategory.isEmpty())
//			throw new IncomeNotFoundException("Income Not Found : " + from + "between" + to);
//	return optionalCategory;
//	}


}

