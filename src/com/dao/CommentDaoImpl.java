package com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Comment;
@Repository
@Scope("prototype")
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	@Override
	public void addComment(Comment comment) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		session.save(comment);
	}
	@Transactional
	@Override
	public void deleteComment(Comment comment) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.delete(comment);
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public void updateComment(Comment comment) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		session.update(comment);
	}
	@Transactional
	@Override
	public List<Comment> seleteComment() {
		// TODO 自动生成的方法存根
		List<Comment> comment = new ArrayList<Comment>();
		Session session = sessionFactory.openSession();
		List list = (List)session.createQuery("From Comments").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Comment u = (Comment) iterator.next();
			comment.add(u);
		}
		return comment;
	}
	@Transactional
	@Override
	public Comment getCommentById(int id) {
		// TODO 自动生成的方法存根	
		Session session=sessionFactory.openSession();
		return session.get(Comment.class,id);
	}

	public List<Comment> getCommentByPid(int id){
		List<Comment> comment = new ArrayList<Comment>();
		Session session = sessionFactory.openSession();
		List product = (List)session.createQuery("From Comment c where c.pid=:pid").setInteger("pid", id).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Comment c = (Comment) iterator.next();
			comment.add(c);
		}
		return comment;
	}
}
