package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import com.arey.LibraryManagementSystem.repository.BookRepository;
import com.arey.LibraryManagementSystem.repository.BorrowerRepository;
import com.arey.LibraryManagementSystem.service.BorrowBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    private final BorrowerRepository borrowerRepository;
    private final BookRepository bookRepository;

    public BorrowBookServiceImpl(BorrowerRepository borrowerRepository, BookRepository bookRepository){
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
    }
    
    @Override
    public Optional<Borrower> borrowBook(int borrowerId, String isbn) {

        bookRepository.findById(isbn).ifPresent(book -> {
            if(book.getCurrentBorrower() == null){
                book.setCurrentBorrower(borrowerId);
                bookRepository.save(book);
            }
        });
        return borrowerRepository.findById(borrowerId);
        
    }

    @Override
    public Optional<Borrower> returnBook(int borrowerId, String isbn) {
        bookRepository.findById(isbn).ifPresent(book -> {
            if(book.getCurrentBorrower() == borrowerId) {
                book.setCurrentBorrower(null);
                bookRepository.save(book);
            }
        });
       //TODO update booksBorrowed of borrower
        return borrowerRepository.findById(borrowerId);
    }

}
