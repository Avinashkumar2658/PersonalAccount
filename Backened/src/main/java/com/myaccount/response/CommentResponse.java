package com.myaccount.response;

import java.util.Date;

public class CommentResponse {

	private Long commentId;
	private String comment;
	private Long diary_id;
	private Date comment_date;

	public CommentResponse() {
		super();
	}

	public CommentResponse(Long commentId, String comment, Long diary_id, Date comment_date) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.diary_id = diary_id;
		this.comment_date = comment_date;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(Long diary_id) {
		this.diary_id = diary_id;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	

}
