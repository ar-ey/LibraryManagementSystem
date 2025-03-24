package com.arey.LibraryManagementSystem.controller;

import com.arey.LibraryManagementSystem.model.entity.Author;
import com.arey.LibraryManagementSystem.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author Author) {
        Author addedAuthor  = authorService.add(Author);
        return ResponseEntity.ok(addedAuthor);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable int id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
