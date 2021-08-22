package com.myaccount.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	private byte[] comment;
	private Long diaryId;
	@Temporal(TemporalType.DATE)
	private Date comment_date;
	public Comment() {
		super();
	}
	public Comment(Long commentId, byte[] comment, Long diaryId, Date comment_date) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.diaryId = diaryId;
		this.comment_date = comment_date;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public byte[] getComment() {
		return comment;
	}
	public void setComment(byte[] comment) {
		this.comment = comment;
	}
	public Long getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(Long diaryId) {
		this.diaryId = diaryId;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	
	
}
