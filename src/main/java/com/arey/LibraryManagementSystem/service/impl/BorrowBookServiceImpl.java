package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import com.arey.LibraryManagementSystem.repository.BorrowerRepository;
import com.arey.LibraryManagementSystem.service.BorrowBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    private BorrowerRepository borrowerRepository;

    public BorrowBookServiceImpl(BorrowerRepository borrowerRepository){
        this.borrowerRepository = borrowerRepository;
    }
    @Override
    public Optional<Borrower> borrowBook(int borrowerId, String isbn) {
       return borrowerRepository.findById(borrowerId);
    }

    @Override
    public void returnBook(int borrowerId, String isbn) {

    }

    @Override
    public boolean bookAvailable(String isbn) {
        return false;
    }
}
