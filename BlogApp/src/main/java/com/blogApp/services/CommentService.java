package com.blogApp.services;

import java.util.List;

import com.blogApp.models.Comment;

public interface CommentService {

	public List<Comment> getCommentsByPostId(Long postId);
	public Comment createComment(Long postId, Comment comment);
	public Comment updateComment(Long id, Comment comment);
	public void deleteComment(Long id);
	
}
