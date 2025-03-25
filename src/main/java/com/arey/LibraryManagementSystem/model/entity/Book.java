package com.arey.LibraryManagementSystem.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @NonNull
    private List<Author> authors;
    private Integer currentBorrower;

}
