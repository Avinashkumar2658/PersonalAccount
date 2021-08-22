package com.myaccount.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myaccount.daos.CommentDao;
import com.myaccount.dto.CommentDto;
import com.myaccount.entities.Comment;
import com.myaccount.response.CommentResponse;

@Service
public class CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	public Comment SaveComment(CommentDto commentDto) {
		
		return commentDao.save(commentDto.getUserComment());
	}
	
	public List<CommentResponse> findAllCommentUpdateByDairyId(Long diaryId) {
		List<Comment> retrievedAllUpdate = commentDao.findAllCommentByDiaryId(diaryId);
		List<CommentResponse> myCommentList = new ArrayList<CommentResponse>();
		ListIterator<Comment> retrievedComment = retrievedAllUpdate.listIterator();
		while (retrievedComment.hasNext()) {
			Comment retrievedData = retrievedComment.next();
			String user_comment = (retrievedData.getComment() == null) ? new String()
					: new String(retrievedData.getComment(), StandardCharsets.UTF_8);
			CommentResponse response = new CommentResponse(retrievedData.getCommentId(), user_comment, retrievedData.getDiaryId(), retrievedData.getComment_date());
			myCommentList.add(response);
		}

		return myCommentList;
 
	}
	
	public void deleteCommentByCommentId(Long commentId) {
		commentDao.deleteById(commentId);
	}

}
