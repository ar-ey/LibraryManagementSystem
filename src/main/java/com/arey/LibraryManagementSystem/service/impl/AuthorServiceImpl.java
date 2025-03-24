package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Author;
import com.arey.LibraryManagementSystem.repository.AuthorRepository;
import com.arey.LibraryManagementSystem.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
