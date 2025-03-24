package com.arey.LibraryManagementSystem.service;

import com.arey.LibraryManagementSystem.model.entity.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> getAll();

    public Author add(Author author);

    public void deleteById(int id);
}
