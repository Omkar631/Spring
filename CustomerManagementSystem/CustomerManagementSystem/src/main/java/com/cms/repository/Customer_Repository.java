package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Customer_entity;

public interface Customer_Repository extends JpaRepository<Customer_entity, Integer>
{

}
