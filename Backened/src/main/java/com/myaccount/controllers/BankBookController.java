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
import com.myaccount.services.BankBookService;

@CrossOrigin("http://localhost:4200")
@RestController
public class BankBookController {
	@Autowired
	BankBookService bankBookService;
	
	
	@GetMapping("/bank/{userId}/{from}/to/{to}")
	public List<Object[]> findByIncomeExpenseThroughBank(@PathVariable Long userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, 
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		System.out.println("inside Controller");
		List<Object[]> optionalCategory = bankBookService.findBankTransactionByUserIdAndDate(userId, from, to);
		if ( optionalCategory.contains(null) || optionalCategory.isEmpty())
			throw new IncomeNotFoundException("There is no bank transaction  : " + from + "   to  " + to + "  date");
	return optionalCategory;
	}

}