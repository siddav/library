package com.sidda.library.db;

import java.util.List;

import com.sidda.library.model.Book;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;

public interface DataHolder {
	
	public void save(Book b);
	
	public void save(User u);
	
	public void save(UserBook ub);
	
	public List<Book> getBooks();
	
	public List<UserBook> getUserBooks();
	
	public List<User> getUsers();
}
