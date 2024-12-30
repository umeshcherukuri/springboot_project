package com.jsp.Boot_book.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PatchMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import com.jsp.Boot_book.controller.dto.Book;
import com.jsp.Boot_book.dao.BookDao;


	@RestController
	@RequestMapping("/book")
	public class Book_Controller {
		//http://localhost:8080/book/save
		@Autowired
		BookDao dao;
		@PostMapping("/save")
	public Book saveBook(@RequestBody   Book book) {
		return dao.saveBook(book);
	}
		//http://localhost:8080/book/fetch/1
	@GetMapping("/fetch/{id}")	
	public Book fetchbook(@PathVariable("id") int id) {
		return dao.fetchbook(id);
	}

	//http://localhost:8080/book/delete/1
	@DeleteMapping("/delete/{id}")	
	public Book deletebook(@PathVariable("id") int id) {
		return dao.Deletebook(id);
	}
	//http://localhost:8080/book/update
		@PatchMapping("/update")	
		public Book updatebook(@RequestBody Book book) {
			return dao.saveBook(book);
		}
		
		@PostMapping("/login/{email}/{pwd}")
		public String login(@PathVariable("email") String Email,@PathVariable("pwd") String pwd)
		{
     		return dao.login(Email, pwd);
		}


}
