/**
 * 
 */
package com.cts.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author HP
 *
 */
@Document
public class Order {
	
	

	/*
	 * @Id private long Id;
	 * 
	 * private String customerId;
	 */
	
	private String orderName;
	
	public Order() {}

	  public Order(String orderName) {
	    this.orderName = orderName;
	  }
	  
	  @Override
	    public String toString() {
	      ObjectMapper mapper = new ObjectMapper();
	      
	      String jsonString = "";
	    try {
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      jsonString = mapper.writeValueAsString(this);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    
	      return jsonString;
	    }

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
