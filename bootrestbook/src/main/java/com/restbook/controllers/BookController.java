package com.restbook.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restbook.entities.Book;
import com.restbook.services.Bookservices;

@RestController
public class BookController {

	@Autowired
	private Bookservices bookServices;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
		{
		
	List<Book> book =	this.bookServices.getAllBooks();
	if(book.size()<=0)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		return ResponseEntity.of(Optional.of(book));
		}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		Book book  = this.bookServices.getBookById(id);
		if(book == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b)
	{
		Book b1 = null;
	try
	{
		b1 = this.bookServices.addBooks(b);
		return ResponseEntity.status(HttpStatus.CREATED).body(b1);   
	}
	catch(Exception e)
	{
	System.out.println("Exception found"+e);
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	
	//deleting the single book
	
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable ("id") int bookid)
	{
		try {
		 this.bookServices.deleteBookById(bookid);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}catch(Exception e)
		{
		System.out.println("Exception "+e);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//updating the book 
	
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Book> updatebook(@PathVariable("bookid") int id, @RequestBody Book book)
	{
		try {
		this.bookServices.updateBookById(id, book);
		return ResponseEntity.ok().body(book);
				
	}catch(Exception e)
		{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
