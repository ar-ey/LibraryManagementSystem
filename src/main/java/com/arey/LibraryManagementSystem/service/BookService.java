package com.arey.LibraryManagementSystem.service;

import com.arey.LibraryManagementSystem.model.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface BookService {
    public List<Book> getAll();

    public Book add(Book book);

    public void deleteById(String isbn);

    public Book update(String isbn);
}
