package com.myaccount.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Income;

@Repository
public interface BalanceSheetDao extends JpaRepository<Income, Long> {
	@Query("select i.incomeAccount, i.amount from Income i where i.userId = ?1 and i.transDate between ?2 and ?3 ORDER BY i.transDate DESC") 
	List<Object[]> findAllIncomeByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);
	
	@Query("select e.expenseAccount, e.amount from Expense e where e.userId = ?1 and e.transDate between ?2 and ?3 ORDER BY e.transDate DESC") 
	List<Object[]> findAllExpenseByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);

	@Query("select SUM(i.amount) from Income i where i.userId = ?1 and i.transDate between ?2 and ?3 ORDER BY i.transDate DESC") 
	List<Object[]> findTotalIncomeSumByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);
	
	@Query("select SUM(e.amount) from Expense e where e.userId = ?1 and e.transDate between ?2 and ?3 ORDER BY e.transDate DESC") 
	List<Object[]> findTotalExpenseSumByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);

}
