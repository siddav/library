package com.sidda.library.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sidda.library.db.DataHolder;
import com.sidda.library.model.UserBook;
import com.sidda.library.model.UserBookStatus;

@Repository
public class UserBookRepository {

	@Autowired
	@Qualifier("inmemory")
	private DataHolder datasource;

	public List<UserBook> findBooksForaGivenUser(String userId, UserBookStatus status) {
		return datasource.getUserBooks().stream().filter(ub -> {
			return ub.getUser().getId().equalsIgnoreCase(userId) && ub.getStatus() == status;
		}).collect(Collectors.toList());
	}

	public void save(UserBook userBook) {
		datasource.save(userBook);
	}
	
	public List<UserBook> findUserBooksByUserId(String userId) {
		return datasource.getUserBooks().stream().filter(ub -> ub.getUser().getId().equalsIgnoreCase(userId)).collect(Collectors.toList());
	}
	
	public List<UserBook> findUserBooksByBookId(String bookId) {
		return datasource.getUserBooks().stream().filter(ub -> ub.getBook().getId().equalsIgnoreCase(bookId)).collect(Collectors.toList());
	}
	
	public List<UserBook> findUserBooksByUserIdAndBookId(String userId, String bookId) {
		return datasource.getUserBooks().stream().filter(ub -> ub.getBook().getId().equalsIgnoreCase(bookId) && ub.getUser().getId().equalsIgnoreCase(userId)).collect(Collectors.toList());
	}
}
