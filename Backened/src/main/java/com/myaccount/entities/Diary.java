package com.myaccount.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long diaryId;
	private byte[] notes_heading;
	private byte[] notes_detail;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long userId;
	public Diary() {
		super();
	}
	public Diary(Long diaryId, byte[] notes_heading, byte[] notes_detail, Date createDate, Long userId) {
		super();
		this.diaryId = diaryId;
		this.notes_heading = notes_heading;
		this.notes_detail = notes_detail;
		this.createDate = createDate;
		this.userId = userId;
	}
	public Long getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(Long diaryId) {
		this.diaryId = diaryId;
	}
	public byte[] getNotes_heading() {
		return notes_heading;
	}
	public void setNotes_heading(byte[] notes_heading) {
		this.notes_heading = notes_heading;
	}
	public byte[] getNotes_detail() {
		return notes_detail;
	}
	public void setNotes_detail(byte[] notes_detail) {
		this.notes_detail = notes_detail;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
   
}
