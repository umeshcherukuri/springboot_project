package com.jsp.Boot_book.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Boot_book.controller.dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
@Query("select a from Book a Where email=?1")
Book findByEmail(String email);
}

