package com.sidda.library.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sidda.library.model.Book;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;

@Repository("inmemory")
public class InMemoryDataHolder implements DataHolder{
	
	private List<Book> books = new ArrayList<>();
	
	private List<UserBook> userBooks = new ArrayList<>();
	
	private List<User> users = new ArrayList<>();
	
	
	public void save(Book b){
		books.add(b);
	}
	
	public void save(User u){
		users.add(u);
	}
	
	public void save(UserBook ub){
		userBooks.add(ub);
	}
	
	public List<Book> getBooks(){
		return Collections.unmodifiableList(books);
	}
	
	public List<UserBook> getUserBooks(){
		return Collections.unmodifiableList(userBooks);
	}
	
	public List<User> getUsers(){
		return Collections.unmodifiableList(users);
	}	
}
