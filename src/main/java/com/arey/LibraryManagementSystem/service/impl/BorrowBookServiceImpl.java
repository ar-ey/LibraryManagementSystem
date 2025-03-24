package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import com.arey.LibraryManagementSystem.repository.BorrowerRepository;
import com.arey.LibraryManagementSystem.service.BorrowBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    private BorrowerRepository borrowerRepository;
    private BookRepository bookRepository;

    public BorrowBookServiceImpl(BorrowerRepository borrowerRepository, AuthorRepository authorRepository){
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
    }
    
    @Override
    public Optional<Borrower> borrowBook(int borrowerId, String isbn) {

        Book book = bookRepository.findById(isbn);

        if(book.isPresent() && !book.isBorrowed) {
            book.setIsBorrowed(true);
        }
        return borrowerRepository.findById(borrowerId).;
        
    }

    @Override
    public void returnBook(int borrowerId, String isbn) {
        book.setIsBorrowed(false);
        //TODO update booksBorrowed of borrower
        return borrowerRepository.findById(borrowerId);
    }

}
