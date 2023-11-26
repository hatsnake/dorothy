package com.ucamp.dorothy.domain;

import lombok.Data;

@Data
public class OrderItem {
	
	private Integer id;	
	private Integer quantity;
	
	private String name;
	private int price;
	private int discount;
	
	private int salePrice;
	private int totalPrice;
	
	public void initSaleTotal() {
		this.salePrice = (int)(this.price * (1-this.discount));
		this.totalPrice = this.salePrice * this.quantity;
		
		
	}
	
	

}
