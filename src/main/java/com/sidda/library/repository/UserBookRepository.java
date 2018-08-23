package com.sidda.library.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sidda.library.model.UserBook;
import com.sidda.library.model.UserBookStatus;

@Repository
public class UserBookRepository {

	List<UserBook> userBooks = new ArrayList<>();

	public List<UserBook> findBooksForaGivenUser(String userId, UserBookStatus status) {
		return userBooks.stream().filter(ub -> {
			return ub.getUser().getId().equalsIgnoreCase(userId) && ub.getStatus() == status;
		}).collect(Collectors.toList());
	}

	public void save(UserBook userBook) {
		userBooks.add(userBook);
	}
	
	public List<UserBook> findUserBooksByUserId(String userId) {
		return Collections.unmodifiableList(userBooks.stream().filter(ub -> ub.getUser().getId().equalsIgnoreCase(userId)).collect(Collectors.toList()));
	}
	
	public List<UserBook> findUserBooksByBookId(String bookId) {
		return Collections.unmodifiableList(userBooks.stream().filter(ub -> ub.getBook().getId().equalsIgnoreCase(bookId)).collect(Collectors.toList()));
	}
	
	public List<UserBook> findUserBooksByUserIdAndBookId(String userId, String bookId) {
		return Collections.unmodifiableList(userBooks.stream().filter(ub -> ub.getBook().getId().equalsIgnoreCase(bookId) && ub.getUser().getId().equalsIgnoreCase(userId)).collect(Collectors.toList()));
	}
}
