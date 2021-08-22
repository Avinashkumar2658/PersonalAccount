package com.myaccount.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.DiaryDao;
import com.myaccount.dto.DiaryDto;
import com.myaccount.entities.Diary;
import com.myaccount.response.DiaryResponse;

@Service
public class DiaryService {
	
	@Autowired
	DiaryDao diaryDao;
	
	public Diary createDiary(DiaryDto diaryDto) {
		
		 return diaryDao.save(diaryDto.getDiary());
	}
	
	public List<DiaryResponse> findAllDiaryUpdateByUserId(Long userId) {
		List<Diary> retrievedAllUpdate = diaryDao.findAllDiaryByUserId(userId);
		List<DiaryResponse> myDiaryList = new ArrayList<DiaryResponse>();
		ListIterator<Diary> retrievedDiary = retrievedAllUpdate.listIterator();
		while (retrievedDiary.hasNext()) {
			Diary retrievedData = retrievedDiary.next();
			String heading = (retrievedData.getNotes_heading() == null) ? new String()
					: new String(retrievedData.getNotes_heading(), StandardCharsets.UTF_8);
			String detail = (retrievedData.getNotes_detail() == null) ? new String()
					: new String(retrievedData.getNotes_detail(), StandardCharsets.UTF_8);
			DiaryResponse response = new DiaryResponse(retrievedData.getDiaryId(), heading, detail, retrievedData.getCreateDate());
			myDiaryList.add(response);
		}

		return myDiaryList;
 
	}
	
	public void deleteDiaryByDiaryId(Long dary_Id) {
		diaryDao.deleteById(dary_Id);
	}

}
