package com.sms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student_entity 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_Id;
	
	private String s_name;
	private String s_address;
	private String s_phone_no;

	public int getS_Id() {
		return s_Id;
	}

	public void setS_Id(int s_Id) {
		this.s_Id = s_Id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_phone_no() {
		return s_phone_no;
	}

	public void setS_phone_no(String s_phone_no) {
		this.s_phone_no = s_phone_no;
	}

	public Student_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student_entity(String s_name, String s_address, String s_phone_no) {
		super();
		this.s_name = s_name;
		this.s_address = s_address;
		this.s_phone_no = s_phone_no;
	}

	@Override
	public String toString() {
		return "Student_ent [s_Id=" + s_Id + ", s_name=" + s_name + ", s_address=" + s_address + ", s_phone_no="
				+ s_phone_no + "]";
	}
}
