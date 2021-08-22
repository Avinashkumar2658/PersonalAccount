package com.myaccount.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.CashBookDao;

@Service
public class CashBookService {

	@Autowired
	CashBookDao cashBookDao;
	
	public List<Object[]> findCashByUserIdAndDate(Long userId, Date from, Date to) {
		List<Object[]> cash = cashBookDao.findAllIncomeExpenseCashByUserIdAndStartDateBetween(userId, from, to);
		return cash;
	}

}
