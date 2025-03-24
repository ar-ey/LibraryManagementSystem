package com.arey.LibraryManagementSystem.service;

import com.arey.LibraryManagementSystem.model.entity.Borrower;

import java.util.List;

public interface BorrowerService {

    public List<Borrower> getAll();

    public Borrower add(Borrower borrower);

    public void deleteById(int id);
}
