package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Order_entity;
import com.cms.model.Order_DTO;
import com.cms.service.Order_service;
import com.cms.utility.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Order_controller
{		

	@Autowired
	private Order_service order_service;

	@Autowired
	private Converter converter;
	
	@PostMapping("/createorder")
	ResponseEntity<Order_DTO> createOrder(@Valid @RequestBody Order_DTO order_DTO) {

		final Order_entity order_entity = converter.convertToEntity(order_DTO);
		return new ResponseEntity<Order_DTO>(order_service.createOrder(order_entity), HttpStatus.CREATED);
	}
	

	@GetMapping("/getallorders")
	List<Order_DTO> getAllOrder() {
		return order_service.getAllOrder();
	}
	

	@GetMapping("/getbyid/{order_id}")
	Order_DTO getOrderById(@PathVariable("order_id") int id) {
		return order_service.getOrderById(id);
	}
	

	@PutMapping("/updatebyid/{order_id}")
	Order_DTO updateOrder(@Valid @PathVariable("order_id") int id, @RequestBody Order_DTO order_DTO) {
		final Order_entity order_entity1 = converter.convertToEntity(order_DTO);
		return order_service.updateById(id, order_entity1);
	}


	@DeleteMapping("/deletebyid/{order_id}")
	String deletebyid(@PathVariable("order_id") int id) {
		return order_service.deleteById(id);

	}
	
	
}
