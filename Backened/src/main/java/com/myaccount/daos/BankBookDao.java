package com.myaccount.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Expense;


@Repository
public interface BankBookDao extends JpaRepository<Expense, Integer> {
	
	String value = "select trans_date, amount, receive_mode from myaccount.income  where  user_id = ?1 and receive_mode = 'BI'  and trans_date between ?2  and ?3\r\n"
			+ "UNION\r\n"
			+ "	select trans_date, amount, receive_mode from myaccount.expenses  where  user_id = ?1 and receive_mode = 'BE'  and trans_date between ?2  and ?3\r\n"
			+ "			ORDER BY \r\n"
			+ "			trans_date Desc ;";
	@Query( value = value , nativeQuery = true)
	List<Object[]> findAllIncomeExpenseBankByUserIdAndStartDateBetween(Long userId, Date startDate, Date endDate);

}
