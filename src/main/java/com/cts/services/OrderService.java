/**
 * 
 */
package com.cts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.domain.Order;
import com.cts.repositories.OrderRepository;
import com.google.gson.Gson;

/**
 * @author HP
 *
 */
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Gson gson;
	
	public List<Order> findAll() {
		Order order = new Order();
		order.setOrderName("test1");
		List<Order> list = new ArrayList<Order>();
		list.add(order);
		return list;
		//return orderRepository.findAll();
	}
	public Order findOrder(@PathVariable String orderId) {
		return orderRepository.findById(orderId).get();
	}
	
	public ResponseEntity<String> createOrder(Order order) {
		ListenableFuture<SendResult<String, String>> result = null;
        result = kafkaTemplate.send("ordertest", gson.toJson(orderRepository.save(order)));
		try {
			return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Order createOrUpdate(Order order) {
		return orderRepository.save(order);
	}
	
	public void removeOrder(String orderId) {
		Order order = orderRepository.findById(orderId).get();
		orderRepository.delete(order);
		return;
	}
	

}
