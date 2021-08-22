package com.myaccount.response;

import java.util.Date;

public class DiaryResponse {
	
	private Long diary_id;
	private String notes_heading;
	private String notes_detail;
	private Date createDate;
	public DiaryResponse() {
		super();
	}
	public DiaryResponse(Long diary_id, String notes_heading, String notes_detail, Date createDate) {
		super();
		this.diary_id = diary_id;
		this.notes_heading = notes_heading;
		this.notes_detail = notes_detail;
		this.createDate = createDate;
	}
	public Long getDiary_id() {
		return diary_id;
	}
	public void setDiary_id(Long diary_id) {
		this.diary_id = diary_id;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
		
	
	

}
