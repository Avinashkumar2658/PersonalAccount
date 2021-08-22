package com.myaccount.dto;

import java.util.Date;

import com.myaccount.entities.Diary;

public class DiaryDto {
	
	private String notes_heading;
	private String notes_detail;
	private Long userId;
	public DiaryDto() {
		super();
	}
	public DiaryDto(String notes_heading, String notes_detail, Long userId) {
		super();
		this.notes_heading = notes_heading;
		this.notes_detail = notes_detail;
		this.userId = userId;
	}
	public String getNotes_heading() {
		return notes_heading;
	}
	public void setNotes_heading(String notes_heading) {
		this.notes_heading = notes_heading;
	}
	public String getNotes_detail() {
		return notes_detail;
	}
	public void setNotes_detail(String notes_detail) {
		this.notes_detail = notes_detail;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Diary getDiary() {
		
		return new Diary(0l, this.notes_heading.getBytes(), this.notes_detail.getBytes(), new Date(), this.userId);
	}
}
