package com.sms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student_entity;
import com.sms.repository.Student_repository;
import com.sms.service.Student_service;

@Service
public class Student_serviceimpl implements Student_service
{
	@Autowired
	Student_repository stdRepo;

	@Override
	public Student_entity createStudent(Student_entity student_entity) {
		
			return stdRepo.save(student_entity);
	}

	@Override
	public List<Student_entity> getAllStudent() {
	
		return stdRepo.findAll();
	}

	@Override
	public Student_entity getStudentById(int id) {
		// TODO Auto-generated method stub
		Student_entity stdEnt = stdRepo.findById(id).get();
		return stdEnt;
	}

	@Override
	public Student_entity updateById(int id, Student_entity student_entity) {
		// TODO Auto-generated method stub
		
		Student_entity stdEnt1 = stdRepo.findById(id).get();
		stdEnt1.setS_name(student_entity.getS_name());
		stdEnt1.setS_address(student_entity.getS_address());
		stdEnt1.setS_phone_no(student_entity.getS_phone_no());
		
		Student_entity stdEnt2 =stdRepo.save(stdEnt1);
		
		return stdEnt2;
	}

	@Override
	public String deleteById(int id) {
		stdRepo.deleteById(id);
		return "Student deleted!!";
	}

}
