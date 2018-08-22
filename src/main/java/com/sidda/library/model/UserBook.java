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

	private UserBookStatus status;

	public UserBook() {

	}

	public UserBook(User u, Book b, UserBookStatus status) {
		this.user = u;
		this.book = b;
		this.status = status;
	}

	public UserBookStatus getStatus() {
		return status;
	}

	public void setStatus(UserBookStatus status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "UserBook [id=" + id + ", book=" + book + ", user=" + user + ", status=" + status + "]";
	}

}
