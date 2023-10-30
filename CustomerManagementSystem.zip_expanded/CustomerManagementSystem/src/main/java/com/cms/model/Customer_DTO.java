package com.cms.model;

import java.util.List;

import com.cms.entity.Order_entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer_DTO
{

	
	private int customer_id;
	
	private String customer_name;

	private String customer_address;
	
	private int customer_phone;


	private boolean status = Boolean.TRUE;

	List<Order_entity> orders;
}
