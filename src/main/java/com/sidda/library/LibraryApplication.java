package com.sidda.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sidda.library.exception.BookNotAvailableException;
import com.sidda.library.exception.BooksLimitExceededException;
import com.sidda.library.model.Book;
import com.sidda.library.model.User;
import com.sidda.library.model.UserBook;
import com.sidda.library.service.BookService;
import com.sidda.library.service.UserBookService;
import com.sidda.library.service.UserService;

@SpringBootApplication
@ComponentScan({ "com.sidda" })
public class LibraryApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(LibraryApplication.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserBookService userBookService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book cleanCode = new Book("978-0-13-235088", "Robert Martin", "Clean Code");
		logger.info("Inserting Book - Clean Code -> {}", bookService.save(cleanCode));

		Book patterns = new Book("978-0-321-12742", "Martin Fowler", "Patterns of Enterprise Applications");
		logger.info("Inserting Book - Patterns of Enterprise Applications -> {}", bookService.save(patterns));

		Book kalki = new Book("978-0-321-12752", "Kevin Missal", "Kalki");
		logger.info("Inserting Book - kalki-> {}", bookService.save(kalki));

		logger.info("All books -> {}", bookService.findAll());

		logger.info("Update Book - cleanCode -> {}",
				bookService.save(new Book(cleanCode.getId(), "978-0-13-235088", "Robert C. Martin", "Clean Code")));

		logger.info("Book find by id 1 -> {}", bookService.findById(1L));

		logger.info("Book find by author Robert Martin -> {}", bookService.findByAuthor("Robert C. Martin"));

		logger.info("Book find by title kalki -> {}", bookService.findByTitle("Kalki"));

		User john = new User("john123", "john", "john@gmail.com");
		logger.info("Inserting User -> {}", userService.save(john));

		User doe = new User("doe13", "doe", "doe@gmail.com");
		logger.info("Inserting User -> {}", userService.save(doe));

		logger.info("All users -> {}", userService.findAll());

		logger.info("User find by name john -> {}", userService.findByName("john"));

		UserBook johnBook1 = userBookService.lendBook(john, cleanCode);
		logger.info("User John lend book cleanCode -> {}", johnBook1);

		UserBook johnBook2 = userBookService.lendBook(john, patterns);
		logger.info("User John lend book patterns -> {}", johnBook2);

		try {
			UserBook johnBook3 = userBookService.lendBook(john, kalki);
			logger.info("User John lend book kalki -> {}", johnBook3);
		} catch (BooksLimitExceededException e) {
			logger.info("Expected - Books limit exceeded exception");
		}
		try {
			UserBook doeBook1 = userBookService.lendBook(doe, cleanCode);
		} catch (BookNotAvailableException e) {
			logger.info("Expected - cant lend the same book until it is returned");
		}

		logger.info("User John return book cleanCode -> {}", userBookService.returnBook(johnBook1));

		UserBook doeBook2 = userBookService.lendBook(doe, cleanCode);
		logger.info("User Doe lend book cleanCode -> {}", doeBook2);
	}
}
