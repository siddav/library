package com.sidda.library.exception;

public class BookNotAvailableException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BookNotAvailableException() {
        super();
    }

    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotAvailableException(Throwable cause) {
        super(cause);
    }
}
