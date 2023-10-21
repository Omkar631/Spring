package com.bms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Book_management_system")
public class Book_entity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_name")
	private String b_name;
	
	@Column(name="book_author")
	private String b_author;
	
	@Column(name="book_price")
	private int b_price;
	
	@Column(name="book_published_date")
	private String b_published_date;

}
