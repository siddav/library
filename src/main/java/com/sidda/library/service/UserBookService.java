package com.sidda.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidda.library.model.Book;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;
import com.sidda.library.model.UserBookStatus;
import com.sidda.library.repository.UserBookRepository;

@Service
public class UserBookService {

	@Autowired
	private UserBookRepository repository;

	public UserBook lendBook(User user, Book book) {
		return repository.save(new UserBook(user, book, UserBookStatus.LEND));
	}

	public UserBook returnBook(UserBook userBook) {
		userBook.setStatus(UserBookStatus.RETURN);
		return repository.save(userBook);
	}	

}
