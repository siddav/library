package com.sidda.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;
	private String author;
	private String title;

	public Book() {

	}

	public Book(String isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}
	
	public Book(Long id, String isbn, String author, String title) {
		this(isbn, author, title);
		this.id = id;				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}	

	public void setTitle(String title) {
		this.title = title;
	}	

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", author=" + author + ", title=" + title 
				+ "]";
	}
}
