package com.facisa.arqi.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
	}
	
	public Order updateOrder(Order order, int id) {
		Order o = orderRepository.getById(id);
		o.setId_client(order.getId_client());
		o.setId_product(order.getId_product());
		o.setQtd(order.getQtd());
		o.setTotal(order.getTotal());
		return orderRepository.save(order);
	}
}
