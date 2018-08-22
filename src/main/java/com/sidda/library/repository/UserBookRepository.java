package com.sidda.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sidda.library.model.UserBook;
import com.sidda.library.model.UserBookStatus;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

	 @Query("SELECT ub FROM UserBook ub where ub.user.id = :userId AND ub.status = :status")
	 List<UserBook> findBooksForaGivenUser(@Param("userId") Long userId, @Param("status") UserBookStatus status);
}
