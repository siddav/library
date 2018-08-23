package com.sidda.library.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sidda.library.model.Book;

@Repository
public class BookRepository {
	private List<Book> books = new ArrayList<>();

	public List<Book> findByAuthor(String author) {
		return Collections.unmodifiableList(books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList()));
	}

	public List<Book> findByTitle(String title) {
		return Collections.unmodifiableList(books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList()));
	}

	public void saveAll(List<Book> books) {
		if (books != null && books.size() > 0) {
			books.addAll(books);
		}
	}

	public Book findById(String id) {
		return books.stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void save(Book b) {
		books.add(b);
	}

	public List<Book> findAll() {
		return Collections.unmodifiableList(books);
	}
}
