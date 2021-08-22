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

import com.myaccount.dto.CommentDto;
import com.myaccount.entities.Comment;
import com.myaccount.response.CommentResponse;
import com.myaccount.services.CommentService;

@CrossOrigin("http://localhost:4200")
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping("/save_comment")
	public Comment createComment(@RequestBody CommentDto commentDto) {
		return commentService.SaveComment(commentDto);
	}
	
	@GetMapping("/comment_update/{diaryId}")
	public List<CommentResponse> findAllCommentUpdateByDiaryId(@PathVariable Long diaryId) {
		return commentService.findAllCommentUpdateByDairyId(diaryId);
	}
	
	@DeleteMapping("/delete_comment/{commentId}")
	public void deleteCommentByCommentId(@PathVariable Long commentId) {
		commentService.deleteCommentByCommentId(commentId);
	}
}
