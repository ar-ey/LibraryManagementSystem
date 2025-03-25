package com.arey.LibraryManagementSystem.controller;

import com.arey.LibraryManagementSystem.model.entity.Book;
import com.arey.LibraryManagementSystem.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        System.out.println("Received ISBN: " + book.getIsbn());
        Book addedBook  = bookService.add(book);
        return ResponseEntity.ok(addedBook);
    }

    @PutMapping("/books/update/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn){
        Book updatedBook = bookService.update(isbn);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable String isbn) {
        bookService.deleteById(isbn);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
