package com.service;

import com.beans.Comment;
import com.dao.CommentDao;

import java.util.List;

@Service
@Scope("prototype")
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    public void add(Comment c){
        commentDao.addComment(c);
    }
    public List<Comment> getCommentByPid(int id){
        commentDao.getCommentByPid(id);
    }
}
