package com.cms.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.entity.Customer_entity;
import com.cms.entity.Order_entity;
import com.cms.model.Customer_DTO;
import com.cms.model.Order_DTO;

@Component
public class Converter
{

//	convert from DTO to Entity
	public Order_entity convertToEntity(Order_DTO order_DTO) {

		Order_entity order_entity = new Order_entity();
		if (order_DTO != null) {
			BeanUtils.copyProperties(order_DTO, order_entity);
		}
		return order_entity;
	}

//	convert from  Entity to DTO
	public Order_DTO convertToDTO(Order_entity order_entity) {

		Order_DTO order_DTO = new Order_DTO();
		if (order_entity != null) {
			BeanUtils.copyProperties(order_entity, order_DTO);
		}
		return order_DTO;
	}

	// ---------------------------------------------------------------------------------------------------------

//	convert from DTO to Entity
	public Customer_entity convertToCustomerEntity(Customer_DTO customer_DTO) {

		Customer_entity customer_entity = new Customer_entity();
		if (customer_DTO != null) {
			BeanUtils.copyProperties(customer_DTO, customer_entity);
		}
		return customer_entity;
	}

//	convert from Entity to DTO
	public Customer_DTO convertToCustomerDTO(Customer_entity customer_entity) {

		Customer_DTO customer_DTO = new Customer_DTO();
		if (customer_entity != null) {
			BeanUtils.copyProperties(customer_entity, customer_DTO);

		}
		return customer_DTO;
	}

}
