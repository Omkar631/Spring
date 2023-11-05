package com.cms.service;

import java.util.List;

import com.cms.entity.Customer_entity;
import com.cms.model.Customer_DTO;


public interface Customer_service
{

	Customer_DTO registerCustomer(Customer_entity customer_entity);

	String assigningOrderToCustomer(int customer_id, int order_id);
	

//	fetch all customer data
	List<Customer_DTO> getAllCustomers();

//	fetch by id
	Customer_DTO getCustomerById(int id);

//	update by id
	Customer_DTO updateCustomerById(int id, Customer_entity customer_entity);

//	delete by id
	String deleteCustomerById(int id);


}
