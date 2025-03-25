package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Author;
import com.arey.LibraryManagementSystem.model.entity.Book;
import com.arey.LibraryManagementSystem.repository.AuthorRepository;
import com.arey.LibraryManagementSystem.repository.BookRepository;
import com.arey.LibraryManagementSystem.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        if(book.getAuthors().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"A book must have at least one author");
        }
        List<Integer> bookAuthorIds = book.getAuthors().stream().map(Author::getAuthorId).toList();
        List<Integer> foundBookAuthorIds = authorRepository.findAllById(bookAuthorIds).stream().map(Author::getAuthorId).toList();
        if(bookAuthorIds.size() == foundBookAuthorIds.size()){
            return bookRepository.save(book);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Could not find authors associated with the book");
    }

    @Override
    public void deleteById(String isbn) {
        bookRepository.deleteById(isbn);
    }

    @Override
    public Book update(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()) {
            Book foundBook = book.get();
            return bookRepository.save(foundBook);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book with an isbn of " +isbn + " does not exist");
    }


}
