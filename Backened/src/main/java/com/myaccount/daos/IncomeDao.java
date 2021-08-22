package com.myaccount.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Income;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long> {

	
	
}
