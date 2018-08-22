package com.sidda.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidda.library.model.UserBook;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {

}
