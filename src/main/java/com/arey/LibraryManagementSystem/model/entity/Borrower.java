package com.arey.LibraryManagementSystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "borrower")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int borrowerId;
    private String name;
    private String contactNumber;
    @ManyToMany
    @JoinTable(
        name = "borrower_books",
        joinColums = @JoinColumn("borrowerId"),
        inverseJoinColumns = @JoinColumn("isbn")
    )
    private List<Book> borrowedBooks;

}
