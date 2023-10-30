package com.cms.service;

import com.cms.entity.Customer_entity;
import com.cms.model.Customer_DTO;

public interface Customer_service
{

	Customer_DTO registerCustomer(Customer_entity customer_entity);

	String assigningOrderToCustomer(int customer_id, int order_id);

}
