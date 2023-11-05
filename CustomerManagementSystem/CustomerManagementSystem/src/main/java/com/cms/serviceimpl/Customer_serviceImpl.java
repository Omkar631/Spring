package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Customer_entity;
import com.cms.entity.Order_entity;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.Customer_DTO;
import com.cms.model.Order_DTO;
import com.cms.repository.Customer_Repository;
import com.cms.repository.Order_Repository;
import com.cms.service.Customer_service;
import com.cms.utility.Converter;

@Service
public class Customer_serviceImpl implements Customer_service
{

	@Autowired
	private Customer_Repository customer_repository1;

	@Autowired
	private Order_Repository order_repository;

	@Autowired
	private  Customer_Repository customer_repository;

	@Autowired
	private Converter converter;

	@Override
	public Customer_DTO registerCustomer(Customer_entity customer_entity) {
		return converter.convertToCustomerDTO(customer_repository.save(customer_entity));
	}

	
	@Override
	public String assigningOrderToCustomer(int customer_id, int order_id) {
		Order_entity order_entity = order_repository.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order ", " order_id ", order_id));

		Customer_entity customer_entity = customer_repository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("Order ", " order_id ", customer_id));

		List<Order_entity> orders = new ArrayList<>();
		orders.add(order_entity);

		customer_entity.setOrders(orders);
		order_entity.setCustomer(customer_entity);

		customer_repository.save(customer_entity);

		return "Order assign to a Customer successfully.....";
	}


	@Override
	public List<Customer_DTO> getAllCustomers() {
		List<Customer_entity> customer_entity2 = customer_repository.findAll();
		List<Customer_DTO> dtoList = new ArrayList<>();

		for (Customer_entity customer_entity : customer_entity2) {
			dtoList.add(converter.convertToCustomerDTO(customer_entity));
		}

		return dtoList;
	}


	@Override
	public Customer_DTO getCustomerById(int id) {
		Customer_entity customer_entity = customer_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer ", " customer_id ", id));
		return converter.convertToCustomerDTO(customer_entity);
	}


	@Override
	public Customer_DTO updateCustomerById(int id, Customer_entity customer_entity) {

		Customer_entity custEnt1 = customer_repository.findById(id).get();
		custEnt1.setCustomer_name(customer_entity.getCustomer_name());
		custEnt1.setCustomer_address(customer_entity.getCustomer_address());
		custEnt1.setCustomer_phone(customer_entity.getCustomer_phone());

		Customer_entity custEnt2 = customer_repository.save(custEnt1);

		return converter.convertToCustomerDTO(custEnt2);
	}


	@Override
	public String deleteCustomerById(int id) {
		customer_repository.deleteById(id);
		return "Customer deleted id:- " + id;
	}
}
