package com.arey.LibraryManagementSystem.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    private String isbn;
    private String title;
    private int publicationYear;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private List<Author> authors;
    private boolean isBorrowed;

}
