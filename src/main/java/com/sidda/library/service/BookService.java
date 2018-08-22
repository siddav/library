package com.sidda.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidda.library.model.Book;
import com.sidda.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public void addBooks(List<Book> books) {
		repository.saveAll(books);
	}

	public Book findByAuthor(String author) {
		return repository.findByAuthor(author);
	}

	public Book findByTitle(String title) {
		return repository.findByTitle(title);
	}
	
	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public Book save(Book b) {
		return repository.save(b);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}
}
