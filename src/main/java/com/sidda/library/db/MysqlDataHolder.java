package com.sidda.library.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sidda.library.model.Book;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;

@Repository("mysql")
public class MysqlDataHolder implements DataHolder{

	@Override
	public void save(Book b) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(UserBook ub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBook> getUserBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
