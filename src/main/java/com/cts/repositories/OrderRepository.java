/**
 * 
 */
package com.cts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.domain.Order;
import com.cts.domains.User;

/**
 * @author HP
 *
 */
public interface OrderRepository extends MongoRepository<Order, String> {
	
	//Order findByOrderId(long orderId);

}
