package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Student_entity;

public interface Student_repository extends JpaRepository<Student_entity, Integer>

{

}
