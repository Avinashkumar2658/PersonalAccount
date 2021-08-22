package com.myaccount.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Income;

@Repository
public interface CashBookDao extends JpaRepository<Income, Integer> {
//	@Query("select e from Income e where e.transDate between ?1 and ?2 " + "Union" + "select s from Expense s where s.transDate between ?1 and ?2" + "ORDER BY e.transDate DESC")
	
	String value = "select trans_date, amount, receive_mode from myaccount.income  where  user_id = ?1 and receive_mode = 'CI'  and trans_date between ?2  and ?3\r\n"
			+ "UNION\r\n"
			+ "	select trans_date, amount, receive_mode from myaccount.expenses  where  user_id = ?1 and receive_mode = 'CE'  and trans_date between ?2  and ?3\r\n"
			+ "			ORDER BY \r\n"
			+ "			trans_date Desc ;";
	@Query( value = value , nativeQuery = true)
	List<Object[]> findAllIncomeExpenseCashByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);
	
	

}
