package com.facisa.arqi.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order")
	public ResponseEntity<List<Order>> getOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
	}
	
	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable int id){
		orderService.deleteOrder(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(order,id));
	}
}
