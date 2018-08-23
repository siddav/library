package com.sidda.library.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sidda.library.exception.BookNotAvailableException;
import com.sidda.library.exception.BooksLimitExceededException;
import com.sidda.library.model.Book;
import com.sidda.library.model.BookStatus;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;
import com.sidda.library.model.UserBookStatus;
import com.sidda.library.repository.UserBookRepository;

@Service
public class UserBookService {

	@Autowired
	private UserBookRepository repository;

	@Value("${library.lend.books.limit}")
	private int lendBooksLimit;

	public void lendBook(User user, Book book) throws BooksLimitExceededException, BookNotAvailableException {
		Assert.notNull(book, "Expecting a valid book");
		if (!book.available()) {
			throw new BookNotAvailableException("Book is not available");
		}
		List<UserBook> userBooks = getAllLendBooks(user);
		userBooks = userBooks != null ? userBooks : new ArrayList<>();
		if (userBooks.size() < lendBooksLimit) {
			book.setStatus(BookStatus.LENT);
			repository.save(new UserBook(user, book, UserBookStatus.LEND));
		} else {
			throw new BooksLimitExceededException();
		}
	}

	public void returnBook(UserBook userBook) {
		userBook.setStatus(UserBookStatus.RETURN);
		userBook.getBook().setStatus(BookStatus.AVAILABLE);
		repository.save(userBook);
	}

	public List<UserBook> getAllLendBooks(User user) {
		List<UserBook> userBooks = repository.findBooksForaGivenUser(user.getId(), UserBookStatus.LEND);
		return userBooks;
	}

	public List<UserBook> getAllReturnBooks(User user) {
		List<UserBook> userBooks = repository.findBooksForaGivenUser(user.getId(), UserBookStatus.RETURN);
		return userBooks;
	}
}
