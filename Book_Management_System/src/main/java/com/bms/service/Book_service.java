package com.bms.service;

import java.util.List;

import com.bms.entity.Book_entity;

public interface Book_service 
{	

//	create new book
	Book_entity createBook(Book_entity book_entity);

//	fetch all books from table
	List<Book_entity> getAllBook();

//	find by id from book table
	Book_entity getBookById(int id);
	
//	delete by id from book table
	String deletebyid(int id);
	
// update by id from book table
	Book_entity updatebyid(int id, Book_entity book_entity);

}
