package com.dao;

import java.util.List;


import javax.annotation.*;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.beans.User;
@Repository
@Scope("prototype")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addUser(User user) {
		Session session=sessionFactory.openSession();
		session.save(user);
	}
	@Override
	public void deleteUser(User user) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.delete(user);
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public void updateUser(User user) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.update(user);
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public List<User> selectUser() {
		// TODO 自动生成的方法存根
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.openSession();
		List list = (List)session.createQuery("From User").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			users.add(u);
		}
		return users;
	}
	@Transactional
	@Override
	public User getUserById(int id) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		return session.get(User.class,id);
	}
	@Transactional
	@Override
	public boolean isExisted(String name) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Transactional
	@Override
	public User getUserByName(String name) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		//User user=session.get(User.class, userName);
		List user = (List)session.createQuery("From User u where u.nickname=:nickname").setString("nickname", name).list();
		if (user.size()>0) 
			for (Iterator iterator = user.iterator();iterator.hasNext();) 
				{
					User u=(User) iterator.next();
					return u;
				}
		return null;
	}
}
