package com.sidda.library.exception;

public class BooksLimitExceededException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BooksLimitExceededException() {
        super();
    }

    public BooksLimitExceededException(String message) {
        super(message);
    }

    public BooksLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public BooksLimitExceededException(Throwable cause) {
        super(cause);
    }
}
