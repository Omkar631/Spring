package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Customer_entity;
import com.cms.model.Customer_DTO;
import com.cms.service.Customer_service;
import com.cms.utility.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Customer_controller {
	
	
	@Autowired
	private Customer_service customer_service;

	@Autowired
	private Converter converter;

	@PostMapping("/createCustomer")
	ResponseEntity<Customer_DTO> createOrder(@Valid @RequestBody Customer_DTO customerDTO) {

		final Customer_entity customer_entity = converter.convertToCustomerEntity(customerDTO);
		return new ResponseEntity<Customer_DTO>(customer_service.registerCustomer(customer_entity), HttpStatus.CREATED);
	}

	@PostMapping("/assign/{customer_id}/{order_id}")
	public String assignOrderToCustomer(@PathVariable("customer_id") int customer_id, @PathVariable("order_id") int order_id) {
		return customer_service.assigningOrderToCustomer(customer_id, order_id);

	}

}
