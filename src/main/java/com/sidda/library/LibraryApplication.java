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
		bookService.save(cleanCode);
		logger.info("Inserting Book - Clean Code -> {}", bookService.findById(cleanCode.getId()));

		Book patterns = new Book("978-0-321-12742", "Martin Fowler", "Patterns of Enterprise Applications");
		bookService.save(patterns);
		logger.info("Inserting Book - Patterns of Enterprise Applications -> {}",
				bookService.findById(cleanCode.getId()));

		Book kalki = new Book("978-0-321-12752", "Kevin Missal", "Kalki");
		bookService.save(kalki);
		logger.info("Inserting Book - kalki-> {}", bookService.findById(kalki.getId()));

		logger.info("All books -> {}", bookService.findAll());

		logger.info("Book find by id -> {}", bookService.findById(cleanCode.getId()));

		logger.info("Book find by author Robert Martin -> {}", bookService.findByAuthor("Robert Martin"));

		logger.info("Book find by title kalki -> {}", bookService.findByTitle("Kalki"));

		User john = new User("john123", "john", "john@gmail.com");
		userService.save(john);
		logger.info("Inserting User -> {}", userService.findById(john.getId()));

		User doe = new User("doe13", "doe", "doe@gmail.com");
		userService.save(doe);
		logger.info("Inserting User -> {}", userService.findById(doe.getId()));

		logger.info("All users -> {}", userService.findAll());

		logger.info("User find by name john -> {}", userService.findByName("john"));
		logger.info("user john lending book cleancode");
		userBookService.lendBook(john, cleanCode);
		logger.info("user john lending book patterns");
		userBookService.lendBook(john, patterns);
		logger.info("User John all lend books -> {}", userBookService.getAllLendBooks(john));

		try {
			logger.info("User John trying to lend book kalki");
			userBookService.lendBook(john, kalki);
		} catch (BooksLimitExceededException e) {
			logger.info("Expected - Books limit exceeded exception");
		}
		try {
			logger.info("User John trying to lend book cleancode");
			userBookService.lendBook(doe, cleanCode);
		} catch (BookNotAvailableException e) {
			logger.info("Expected - cant lend the same book until it is returned");
		}

		userBookService.getAllLendBooks(john).forEach(lendBook -> {
			logger.info("User john returning book {}", lendBook.getBook().getTitle());
			userBookService.returnBook(lendBook);	
		});
		

		userBookService.lendBook(doe, cleanCode);
		logger.info("User Doe lend book cleanCode");
		logger.info("User doe all books {}", userBookService.getAllLendBooks(doe));
	}
}
