package com.dao;

import java.util.List;

import com.beans.Comment;

public interface CommentDao {
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public void updateComment(Comment comment);
	public List<Comment> seleteComment();
	public Comment getCommentById(int id);
	public List<Comment> getCommentByPid(int id);
}
