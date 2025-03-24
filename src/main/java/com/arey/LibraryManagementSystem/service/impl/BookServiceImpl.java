package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Book;
import com.arey.LibraryManagementSystem.repository.BookRepository;
import com.arey.LibraryManagementSystem.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(String isbn) {
        bookRepository.deleteById(isbn);
    }


}
