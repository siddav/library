package com.sidda.library.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sidda.library.db.DataHolder;
import com.sidda.library.model.Book;

@Repository
public class BookRepository {
	
	@Autowired
	@Qualifier("inmemory")
	private DataHolder datasource;

	public List<Book> findByAuthor(String author) {
		return datasource.getBooks().stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
	}

	public List<Book> findByTitle(String title) {
		return datasource.getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
	}

	public void saveAll(List<Book> books) {
		books.forEach(book -> {
			datasource.save(book);
		});		
	}

	public Book findById(String id) {
		return datasource.getBooks().stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void save(Book b) {
		datasource.save(b);
	}

	public List<Book> findAll() {
		return datasource.getBooks();
	}
	
}
