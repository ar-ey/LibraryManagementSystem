package com.arey.LibraryManagementSystem.repository;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
}
