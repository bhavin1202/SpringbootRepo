package com.restbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.restbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	
public Book findByBookid(int id);

	
	
}
