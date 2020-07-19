/**
 * 
 */
package com.cts.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.domain.Order;
import com.cts.dtos.OrderDto;
import com.cts.repositories.OrderRepository;
import com.google.gson.Gson;

/**
 * @author HP
 *
 */
@RestController
public class OrderController {
	
	/**
	* Order API with versioning!!
	* HTTP METHOD   URN                    DESCRIPTION
	* GET           /v1/orders             Retrieves list of orders!!
	* GET           /v1/orders/{orderId}   Retrieves specific order!!
	* POST          /v1/orders             Create a order!!
	* PUT           /v1/orders/{orderId}   Update a specific order!!
	* PATCH         /v1/orders/{orderId}   Partial update a order!!
	* DELETE        /v1/order/{orderId}    Delete a order!!
	*/

	/**
	 * @RequestBody: 
	 * 
	 * @ResponseBody: 
	 * 
	 * @RequestMapping:
	 * 
	 * Serialization and Deserialization of Data Transfer Object!!
	 * 
	 */
	/*
	* @ResponseBody // Spring will bind the return value to outgoing HTTP response body and 
	* serialize the Java Object state to HttpResponse Body!!
	* 
	// @RequestBody: @RequestBody Maps or bind the Http Request Body to a transfer object(DTO) or Domain Object.
	// and enabling automatic deserialization of the inbound HttpRequest body into Java Object.
	*/
	
	@Autowired
	OrderRepository orderRepository;
	
	 @Autowired
	 private KafkaTemplate<String, String> kafkaTemplate;
	 
	 @Autowired
	 private Gson gson;
	
	@RequestMapping(value = "/v1/orders", method = RequestMethod.GET)
	public @ResponseBody List<Order> findAll() {
			return orderRepository.findAll();	
	}
	
		@RequestMapping(value = "/v1/orders/{orderId}", method = RequestMethod.GET , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
		public @ResponseBody Order findOrder(@PathVariable String orderId) {
//			orderRepository.findById(orderId);
//			OrderDto orderDto = new OrderDto();
//			orderDto.setOrderId(11111);
//			orderDto.setOrderName("test_order");
//			Optional<Order> order  = orderRepository.findById(orderId).get();
//			Order ord = order.get();
			return orderRepository.findById(orderId).get();
			}
		
		@RequestMapping(value = "/v1/orders", method = RequestMethod.POST) 
		public @ResponseBody ResponseEntity createOrder(@RequestBody Order order) throws InterruptedException, ExecutionException {
			ListenableFuture<SendResult<String, String>> result = null;
	        result = kafkaTemplate.send("ordertest", gson.toJson(orderRepository.save(order)));
			return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
		}
		
		@RequestMapping(value = "/v1/orders/{orderId}", method = RequestMethod.PUT)
		public @ResponseBody OrderDto createOrUpdate(@RequestBody OrderDto orderDto, @PathVariable long orderId) {
			return null;	
		}
		
		@RequestMapping(value = "/v1/orders/{orderId}", method = RequestMethod.PATCH)
		public @ResponseBody OrderDto partialUpdate(@RequestBody Map<String,String> map,@PathVariable long orderId) {
			return null;
		}
		
		@RequestMapping(value = "/v1/orders/{orderId}", method = RequestMethod.DELETE)
		public @ResponseBody OrderDto removeOrder(@PathVariable long orderId) {
			return null;
		}

}
