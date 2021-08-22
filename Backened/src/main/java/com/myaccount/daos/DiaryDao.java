package com.myaccount.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Diary;

@Repository
public interface DiaryDao extends JpaRepository<Diary, Long> {

	List<Diary> findAllDiaryByUserId(Long userId);

}
