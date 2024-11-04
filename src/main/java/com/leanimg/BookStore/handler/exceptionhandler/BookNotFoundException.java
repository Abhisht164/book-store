package com.leanimg.BookStore.handler.exceptionhandler;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
