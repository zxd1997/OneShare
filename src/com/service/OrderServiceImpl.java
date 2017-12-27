package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.beans.Order;
import com.beans.Product;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.dao.UserDao;
@Service 
@Scope("prototype")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;
	@Override
	public void add(Order order) {
		// TODO 自动生成的方法存根
		orderDao.addOrder(order);
	}

	@Override
	public void del(Order order) {
		// TODO 自动生成的方法存根
		orderDao.deleteOrder(order);
	}

	@Override
	public void update(Order order) {
		// TODO 自动生成的方法存根
		orderDao.updateOrder(order);
	}

	@Override
	public List<Order> getOrders() {
		// TODO 自动生成的方法存根
		return orderDao.seleteOrder();
	}

	@Override
	public Order getOrder(int id) {
		// TODO 自动生成的方法存根
		return orderDao.getOrderById(id);
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		// TODO 自动生成的方法存根
		return orderDao.getOrderByUserId(id);
	}

	@Override
	public void createNewOrder(String userName, String productName,Order o) {
		// TODO 自动生成的方法存根
		Product p=productDao.getProductByName(productName);
		o.setUserId(userDao.getUserByName(userName).getId());
		o.setProductId(p.getId());
		o.setOrderTime(new Date());
		o.setReturnTime(new Date());
		o.setOrderCode("");
		switch (o.getPayType()) {
		case 1:
			o.setCost(p.getRent1());
			break;
		case 2:
			o.setCost(p.getRent2());
			break;
		case 3:
			o.setCost(p.getRent3());
		}
		p.setOnUse(true);
		productDao.updateProduct(p);
		add(o);
	}

	@Override
	public void returnOrder(int id) {
		// TODO 自动生成的方法存根
		Order o=orderDao.getOrderById(id);
		Product p=productDao.getProductById(o.getProductId());
		p.setOnUse(false);
		orderDao.deleteOrder(o);
		productDao.updateProduct(p);
	}
	

}
