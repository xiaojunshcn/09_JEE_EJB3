package com.joe.service;

import java.util.List;

import com.joe.bean.Order;

public interface IOrderService {
	public String getUserName(String name);
	public Order getOrder(String orderId);
	public List<Order> getOrders();
}
