package com.cms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer_entity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	
	@Column(length = 35)
	private String customer_name;
	
	@Column(length = 100)
	private String customer_address;
	
	private int customer_phone;

	private boolean status = Boolean.TRUE;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("customer")
	List<Order_entity> orders;

}
