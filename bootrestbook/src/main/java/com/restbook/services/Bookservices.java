package com.restbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restbook.dao.BookRepository;
import com.restbook.entities.Book;

@Service
//@Component can also be used
public class Bookservices {

	@Autowired
	private BookRepository bookRepository;
//	private  static List<Book> list = new ArrayList<>();
	
//	static {
	//			list.add(new Book(1,"Java Reference","ASD"));
		//		list.add(new Book(2,"Java Bible","DFG"));
			//	list.add(new Book(3,"Think in java","IUY"));
	//}
	
	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list; 	
	}
	
	//get book by id
	public Book getBookById(int id)
	{
		Book book = null;
		try {
		book = this.bookRepository.findByBookid(id);
			//book = list.stream().filter(e->e.getBookid()==id).findFirst().get();
		}
		catch(Exception e)
		{
		System.out.println("Exception raised"+e);
		}
		
			return book;
	}
	
	//for adding book using post
	
	public Book addBooks(Book book)
	{
		//list.add(book);
		Book b = (Book) this.bookRepository.save(book);
		return b;
	}
	
	
	public void deleteBookById(int id)
	{
		//list= list.stream().filter(book ->book.getBookid()!=id).collect(Collectors.toList());
		
		this.bookRepository.deleteById(id);
	}
	
	
	
	public void updateBookById(int id, Book book)
	{
		
		//list = list.stream().map(b->{
			//if(b.getBookid()== id)
		//	{
			//	b.setAuthor(book.getAuthor());
			//	b.setName(book.getName());
			//}
			//return b;
		//}).collect(Collectors.toList());
		
		book.setBookid(id);
		
	this.bookRepository.save(book);
		
	}
	
	
}
