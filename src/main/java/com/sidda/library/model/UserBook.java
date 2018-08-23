package com.sidda.library.model;

import com.sidda.library.util.Utils;

public class UserBook {

	private String id;
	private Book book;
	private User user;
	private UserBookStatus status;

	public UserBook() {
		this.id = Utils.newIDString();
	}

	public UserBook(User u, Book b, UserBookStatus status) {
		this();
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
