package com.arey.LibraryManagementSystem.service;

import com.arey.LibraryManagementSystem.model.entity.Borrower;

import java.util.Optional;

public interface BorrowBookService {

    Optional<Borrower> borrowBook(int borrowerId, String isbn);

    Optional<Borrower> returnBook(int borrowerId, String isbn);

}
