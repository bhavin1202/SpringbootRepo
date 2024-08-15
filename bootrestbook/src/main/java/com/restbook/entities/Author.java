package com.restbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int Authorid;
	
	private String firstname;
	
	private String lastname;
	private String language;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int authorid, String firstname, String lastname, String language) {
		super();
		Authorid = authorid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.language = language;
	}
	public int getAuthorid() {
		return Authorid;
	}
	public void setAuthorid(int authorid) {
		Authorid = authorid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
