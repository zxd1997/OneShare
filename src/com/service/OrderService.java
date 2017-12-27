package com.service;

import java.util.List;

import com.beans.Order;

public interface OrderService {
	public void add(Order order);
	public void del(Order order);
	public void update(Order order);
	public List<Order> getOrders();
	public Order getOrder(int id);
	public List<Order> getOrderByUserId(int id);
	public void createNewOrder(String userName,String productName,Order o);
	public void returnOrder(int id);
}
