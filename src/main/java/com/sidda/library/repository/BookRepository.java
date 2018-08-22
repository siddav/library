package com.sidda.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sidda.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b where b.author = :author")
	Book findByAuthor(@Param("author") String author);

    @Query("SELECT b FROM Book b where b.title = :title")
	Book findByTitle(@Param("title") String title);
}
