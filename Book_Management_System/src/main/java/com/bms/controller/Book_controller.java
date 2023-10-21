package com.bms.controller;

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

import com.bms.entity.Book_entity;
import com.bms.service.Book_service;

@RestController
@RequestMapping("/api")
public class Book_controller 
{
	
	@Autowired
	Book_service bookService;

//	method for create new book
	@PostMapping("/createbook")
	ResponseEntity<Book_entity> createBook(@RequestBody Book_entity book_entity) {
		return new ResponseEntity<Book_entity>(bookService.createBook(book_entity), HttpStatus.CREATED);
	}

//	method for fetch all book 
	@GetMapping("/getallbook")
	List<Book_entity> get_All_Book() {
		return bookService.getAllBook();
	}

//	method for fetch book from id
	@GetMapping("/findbookbyid/{b_id}")
	Book_entity findById(@PathVariable("b_id") int id) {
		return bookService.getBookById(id);
	}

//	method for delete book by id
	@DeleteMapping("deletebookbyid/{b_id}")
	String deletebyid(@PathVariable("b_id") int id) {
		return bookService.deletebyid(id);
	}

//	method for update book by id
	@PutMapping("/updatebyid/{b_id}")
	Book_entity updateById(@PathVariable("b_id") int id, @RequestBody Book_entity book_entity) {
		return bookService.updatebyid(id, book_entity);

	}


}
