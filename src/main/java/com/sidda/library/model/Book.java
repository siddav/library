package com.sidda.library.model;

import com.sidda.library.util.Utils;

public class Book {
	
	private String id;
	private String isbn;
	private String author;
	private String title;
	private BookStatus status;

	public Book() {
      this.id = Utils.newIDString();
	}

	public Book(String isbn, String author, String title) {
		this();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.status = BookStatus.AVAILABLE;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public boolean available() {
		return (this.status == BookStatus.AVAILABLE);
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", author=" + author + ", title=" + title + ", status=" + status
				+ "]";
	}
}
