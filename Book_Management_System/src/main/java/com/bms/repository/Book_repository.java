package com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.entity.Book_entity;

public interface Book_repository extends JpaRepository<Book_entity, Integer>
{

}
