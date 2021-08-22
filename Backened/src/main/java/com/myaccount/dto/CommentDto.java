package com.myaccount.dto;

import java.util.Date;

import com.myaccount.entities.Comment;

public class CommentDto {

	private String user_comment;
	private Long diary_id;

	public CommentDto() {
		super();
	}

	public CommentDto(String user_comment, Long diary_id) {
		super();
		this.user_comment = user_comment;
		this.diary_id = diary_id;
	}

	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}

	public Long getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(Long diary_id) {
		this.diary_id = diary_id;
	}

	public Comment getUserComment() {
		return new Comment(0l, this.user_comment.getBytes(), this.diary_id, new Date());
	}
}
