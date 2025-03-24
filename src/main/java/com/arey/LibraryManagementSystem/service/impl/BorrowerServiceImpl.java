package com.arey.LibraryManagementSystem.service.impl;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import com.arey.LibraryManagementSystem.repository.BorrowerRepository;
import com.arey.LibraryManagementSystem.service.BorrowerService;

import java.util.List;

public class BorrowerServiceImpl implements BorrowerService {

    private BorrowerRepository borrowerRepository;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository){
        this.borrowerRepository = borrowerRepository;
    }
    @Override
    public List<Borrower> getAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower add(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public void deleteById(int id) {
        borrowerRepository.deleteById(id);
    }


}
