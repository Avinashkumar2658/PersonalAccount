package com.myaccount.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.myaccount.daos.DayBookDao;


@Service
public class DayBookService {

	@Autowired
	DayBookDao dayBookDao;
	@Query("ORDER BY transDate DESC") 
	public List<List<Object[]>> findIncomeExpenseByDate(Long userId, Date startDate, Date endDate) {
		 
		List<Object[]> income = dayBookDao.findAllIncomeByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<Object[]> expense = dayBookDao.findAllExpenseByUserIdAndStartDateBetween(userId, startDate, endDate);
		List<List<Object[]>> arr = new ArrayList<List<Object[]>>();
		arr.add(income);
		arr.add(expense);
		return arr;
	}
//	public List<Object[]> findExpenseByDate(Date from, Date to) {
//		List<Object[]> expense = dayBookDao.findExpenseByStartDateBetween(from, to);
//		return expense;
//	}
}
