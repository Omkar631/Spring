package com.sms.controller;

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

import com.sms.entity.Student_entity;
import com.sms.service.Student_service;

@RestController
@RequestMapping("/api")
public class Student_controller
{
	@Autowired
	Student_service student_service;

	@PostMapping("/createstudent")
	ResponseEntity<Student_entity> createStudent(@RequestBody Student_entity student_entity) {
		return new ResponseEntity<Student_entity>(student_service.createStudent(student_entity), HttpStatus.CREATED);
	}

	@GetMapping("/getallstudent")
	List<Student_entity> getAllStudent() {
		return student_service.getAllStudent();
	}

	@GetMapping("/getbyid/{s_id}")
	Student_entity getStudentById(@PathVariable("s_id") int id) {
		return student_service.getStudentById(id);

	}

	@PutMapping("/updatebyid/{s_id}")
	Student_entity updateStudent(@PathVariable("s_id") int id, @RequestBody Student_entity student_ent) {
		return student_service.updateById(id, student_ent);

	}

	@DeleteMapping("/deletebyid/{s_id}")
	String deletebyid(@PathVariable("s_id") int id) {
		return student_service.deleteById(id);

	}

}
