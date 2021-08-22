package com.myaccount.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myaccount.entities.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

	List<Comment> findAllCommentByDiaryId(Long diaryId);

}
