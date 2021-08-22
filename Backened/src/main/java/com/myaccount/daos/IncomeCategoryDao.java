package com.myaccount.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.IncomeCategory;

@Repository
public interface IncomeCategoryDao extends JpaRepository<IncomeCategory, Long> {
	
	public List<IncomeCategory> findAllByUserId(Long userId);
}
