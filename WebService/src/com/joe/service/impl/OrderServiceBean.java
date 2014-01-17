package com.joe.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.joe.bean.Order;
import com.joe.service.IOrderService;

@WebService(targetNamespace="http://ws.joe.com",
			name="IOrderService",
			serviceName = "OrderServiceBean")
@Stateless
@Remote(IOrderService.class)
public class OrderServiceBean implements IOrderService {

	@Override
	public String getUserName(String name) {
		return name;
	}

	@Override
	public Order getOrder(String orderId) {
		//here it is not from db, just a data sample
		Order order = new Order();
		order.setOrderId(orderId);
		order.setName("big joe");
		return order;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> persons = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setOrderId("001");
		order1.setName("big joe 1");
		Order order2 = new Order();
		order2.setOrderId("002");
		order2.setName("big joe 2");
		persons.add(order1);
		persons.add(order2);
		return persons;
	}
}