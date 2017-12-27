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

import com.beans.Order;
import com.beans.Product;
@Repository
@Scope("prototype")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	@Override
	public void addOrder(Order order) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		session.save(order);
	}
	@Transactional
	@Override
	public void deleteOrder(Order order) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.delete(order);
			session.flush();
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	@Transactional
	@Override
	public void updateOrder(Order order) {
		// TODO 自动生成的方法存根
		Session session=sessionFactory.openSession();
		Transaction tc=session.beginTransaction();
		try {
			session.update(order);
			session.flush();
			tc.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Transactional
	@Override
	public List<Order> seleteOrder() {
		// TODO 自动生成的方法存根
		List<Order> order = new ArrayList<Order>();
		Session session = sessionFactory.openSession();
		List list = (List)session.createQuery("From Order").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Order u = (Order) iterator.next();
			order.add(u);
		}
		return order;
	}
	@Transactional
	@Override
	public Order getOrderById(int id) {
		// TODO 自动生成的方法存根	
		Session session=sessionFactory.openSession();
		return session.get(Order.class,id);
	}
	@Override
	public List<Order> getOrderByUserId(int id) {
		// TODO 自动生成的方法存根
		List<Order> order = new ArrayList<Order>();
		Session session=sessionFactory.openSession();
		List product = (List)session.createQuery("From Order o where o.userId=:userId").setInteger("userId", id).list();
		if (product.size()>0) 
			for (Iterator iterator = product.iterator();iterator.hasNext();) 
				{
					Order o=(Order) iterator.next();
					order.add(o);
				}
		return order;
	}
}
