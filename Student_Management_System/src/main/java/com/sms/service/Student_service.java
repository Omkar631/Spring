package com.sms.service;

import java.util.List;

import com.sms.entity.Student_entity;



public interface Student_service
{
	//for create new student
		Student_entity createStudent(Student_entity student_entity);
		
		//fetch all student data
		List<Student_entity> getAllStudent();
		
		// fetch by Id
		Student_entity getStudentById(int id);
		
		//update by id
		Student_entity updateById(int id, Student_entity student_entity);
		
		// delete by id
		String deleteById(int id);
		

}
