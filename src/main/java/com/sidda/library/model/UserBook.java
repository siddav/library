package com.sidda.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserBook {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn
	private Book book;
	@ManyToOne
	@JoinColumn
	private User user;

	public UserBook() {

	}

	public UserBook(Book b, User u) {
		this.book = b;
		this.user = u;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
