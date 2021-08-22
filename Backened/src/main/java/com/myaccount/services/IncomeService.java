package com.myaccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.IncomeDao;
import com.myaccount.entities.Income;

@Service
public class IncomeService {

	@Autowired
	IncomeDao incomeDao;
	
	@Autowired
	UserService userService;
	
	public Long createIncome(Income income) {
		Long userId = income.getUserId();
		float incomeAmount = income.getAmount();
		List<Object> totalAmount = userService.findNetAmountByUserId(userId);
		float r = (float) totalAmount.get(0);
		System.out.println(r);
		float netAmount = (float) (r   + incomeAmount);
		userService.updateAmount(userId, netAmount);
		income = incomeDao.save(income);
		return income.getIncomeId();
	}

	public Income updateIncome(Income income) {
		return incomeDao.save(income);
	}

	public void deleteIncome(Long incomeId) {
		incomeDao.deleteById(incomeId);
	}

	public Optional<Income> findIncomeById(Long incomeId) {
		return incomeDao.findById(incomeId);
	}

	public List<Income> findAllIncomes() {
		return incomeDao.findAll();
	}


}
