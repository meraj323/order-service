/**
 * 
 */
package com.cts;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cts.domain.Order;
import com.cts.repositories.OrderRepository;
import com.cts.services.OrderService;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author HP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	OrderService orderService;
	
	@Before
	public void before() {
		
	}
	
	@After
	public void after() {
		
	}
	
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	@AfterClass
	public static void afterClass() {
		
	}
	
	@Test
	public void findAllOrder() {
		List<Order> allOrder = orderService.findAll();
		System.out.println("All orderssssssssssssss");
		System.out.println(allOrder);
		//org.springframework.util.Assert.notEmpty(allOrder);
	}

}
