package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Order_entity;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.Order_DTO;
import com.cms.repository.Order_Repository;
import com.cms.service.Order_service;
import com.cms.utility.Converter;



@Service
public class Order_serviceImpl implements Order_service
{

	@Autowired
	private Order_Repository order_repository;

	@Autowired
	private Converter converter;
	


	@Override
	public Order_DTO createOrder(Order_entity order_entity) {
		Order_entity order_entity2 = order_repository.save(order_entity);
		return converter.convertToDTO(order_entity2);
	}

	@Override
	public List<Order_DTO> getAllOrder() {
		List<Order_entity> order_entity3 = order_repository.findAll();
		List<Order_DTO> dtoList = new ArrayList<>();

		for (Order_entity order_entity : order_entity3) {
			dtoList.add(converter.convertToDTO(order_entity));
		}

		return dtoList;
	}

	@Override
	public Order_DTO getOrderById(int id) {
		Order_entity order_entity = order_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order ", " order_id ", id));
		return converter.convertToDTO(order_entity);
	}

	@Override
	public Order_DTO updateById(int id, Order_entity order_entity) {

		Order_entity ordEnt1 = order_repository.findById(id).get();
		ordEnt1.setOrder_name(order_entity.getOrder_name());
		ordEnt1.setOrder_quantity(order_entity.getOrder_quantity());
		ordEnt1.setOrder_price(order_entity.getOrder_price());

		Order_entity ordEnt2 = order_repository.save(ordEnt1);

		return converter.convertToDTO(ordEnt2);
	}

	@Override
	public String deleteById(int id) {
		order_repository.deleteById(id);
		return "Order deleted id:- " + id;
	}
	
	
	
	
	
	
	
}
