/**
 * 
 */
package com.cts.dtos;

/**
 * @author HP
 *
 */
public class OrderDto {
	
	private long orderId;
	
	private String orderName;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	
}
