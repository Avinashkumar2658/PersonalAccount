package com.myaccount.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.myaccount.daos.BalanceSheetDao;

@Service
public class BalanceSheetService {

	@Autowired
	BalanceSheetDao balanceSheetDao;
	@Query("ORDER BY transDate DESC") 
	public List<List<Object[]>> findIncomeExpenseByDate(Long userId, Date startDate, Date endDate) {
		 
		List<Object[]> income = balanceSheetDao.findAllIncomeByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<Object[]> expense = balanceSheetDao.findAllExpenseByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<Object[]> totalIncome = balanceSheetDao.findTotalIncomeSumByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<Object[]> totalExpense = balanceSheetDao.findTotalExpenseSumByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<List<Object[]>> arr = new ArrayList<List<Object[]>>();
		arr.add(income);
		arr.add(expense);
		arr.add(totalIncome);
		arr.add(totalExpense);
		return arr;
	}
}
