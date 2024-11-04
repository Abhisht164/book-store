package com.leanimg.BookStore.controller;

import com.leanimg.BookStore.entity.Book;
import com.leanimg.BookStore.handler.exceptionhandler.BookNotFoundException;
import com.leanimg.BookStore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedBook=bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable("id") Long bookId){

        try {
            Book book = bookService.getBookById(bookId);
            return ResponseEntity.ok(book);
        } catch (BookNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){

        List<Book> bookList=bookService.getAllBooks();
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long bookId,@RequestBody Book book){
        book.setId(bookId);
        Book updatedBook=bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){

        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book was deleted successfully",HttpStatus.OK);
    }


}
