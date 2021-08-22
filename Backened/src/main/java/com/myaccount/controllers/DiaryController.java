package com.myaccount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myaccount.dto.DiaryDto;
import com.myaccount.entities.Diary;
import com.myaccount.response.DiaryResponse;
import com.myaccount.services.DiaryService;

@CrossOrigin("http://localhost:4200")
@RestController
public class DiaryController {

	@Autowired
	DiaryService diaryService;
	
	@PostMapping("/save_diary")
	public Diary createDiary(@RequestBody DiaryDto diaryDto) {
		System.out.println(diaryDto);
		return diaryService.createDiary(diaryDto);
	}
	
	@GetMapping("/diary_update/{userId}")
	public List<DiaryResponse> findAllDiaryUpdateByUserId(@PathVariable Long userId) {
		return diaryService.findAllDiaryUpdateByUserId(userId);
	}
	
	@DeleteMapping("/delete_notes/{diaryId}")
	public void deleteDiaryByDiaryId(@PathVariable Long diaryId) {
		diaryService.deleteDiaryByDiaryId(diaryId);
	}
} 
