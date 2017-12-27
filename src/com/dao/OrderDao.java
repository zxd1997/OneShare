package com.dao;

import java.util.List;

import com.beans.Order;


public interface OrderDao {
	public void addOrder(Order order);
	public void deleteOrder(Order order);
	public void updateOrder(Order order);
	public List<Order> seleteOrder();
	public Order getOrderById(int id);
	public List<Order> getOrderByUserId(int id);
}
