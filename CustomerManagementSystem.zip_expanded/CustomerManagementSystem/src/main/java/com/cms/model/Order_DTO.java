package com.cms.model;

import com.cms.entity.Customer_entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Order_DTO 
{

	
	@NotNull
	private int order_id;
	
	@NotNull
	@Size(min = 2, max = 35, message = "your order should be minimum 2....")
	private String order_name;
	
	@NotNull
	@Size(min = 5, max = 100, message = "your quantity should be minimum 5....")
	private int order_quantity;
	
	@NotNull
	private int order_price;

	private Customer_entity customer;
}
