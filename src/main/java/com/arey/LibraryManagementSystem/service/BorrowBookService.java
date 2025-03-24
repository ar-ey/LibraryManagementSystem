package com.arey.LibraryManagementSystem.service;

import com.arey.LibraryManagementSystem.model.entity.Borrower;

import java.util.Optional;

public interface BorrowBookService {

    public Optional<Borrower> borrowBook(int borrowerId, String isbn);

    public void returnBook(int borrowerId, String isbn);

    public boolean bookAvailable(String isbn);
}
