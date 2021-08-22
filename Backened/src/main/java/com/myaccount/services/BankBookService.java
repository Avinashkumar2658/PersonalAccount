package com.myaccount.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.BankBookDao;

@Service
public class BankBookService {
	
	@Autowired
	BankBookDao bankBookDao;
	
	public List<Object[]> findBankTransactionByUserIdAndDate(Long userId, Date from, Date to) {
		List<Object[]> bank = bankBookDao.findAllIncomeExpenseBankByUserIdAndStartDateBetween(userId, from, to);
		return bank;
	}


}
