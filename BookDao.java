package com.jsp.Boot_book.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Boot_book.controller.dto.Book;
import com.jsp.Boot_book.controller.repository.BookRepository;

@Repository
public class BookDao {
	@Autowired
	BookRepository repository;
    public Book saveBook(Book book) {
    	return repository.save(book);
    }
    public Book fetchbook(int id) {
    	Optional<Book>db=repository.findById(id);
    	if(db.isPresent()) {
    		return db.get();
    	}else
    		return null;
    }
    public Book Deletebook(int id) {
    	Optional<Book>db=repository.findById(id);
    	if(db.isPresent()) {
    		Book book=db.get();
    		repository.delete(book);
    		//repository.deleteById(id);
    		return book;
    	}else
    		return null;
    }
    public Book updatebook(Book book) {
    	Optional<Book>db=repository.findById(book.getId());
    	if(db.isPresent()) {
    		Book bookDb=db.get();
    		if(book.getName()==null)
    			book.setName(bookDb.getName());
    		if(book.getEmail()==null)
    			book.setEmail(bookDb.getEmail());
    		if(book.getPwd()==null)
    			book.setPwd(bookDb.getPwd());
    		if(book.getAddress()==null)
    			book.setAddress(book.getAddress());	
    		return repository.save(book);
    	}else
    		return null;
    }
    
    public String login(String Email, String pwd) {
    	Book book=repository.findByEmail(Email);
    	if(book !=null) {
    		if (book.getPwd().equals(pwd)) {
    			return "login Success";
    		}else
    			return "pwd mismatch";
    		
    	}
    	else
    		return "email not found";

    }
}
    
