package com.arey.LibraryManagementSystem.controller;

import com.arey.LibraryManagementSystem.model.entity.Borrower;
import com.arey.LibraryManagementSystem.service.BorrowBookService;
import com.arey.LibraryManagementSystem.service.BorrowerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BorrowerController {

    private BorrowerService borrowerService;
    private BorrowBookService borrowBookService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping("/borrowers")
    public ResponseEntity<List<Borrower>> getBorrowers() {
        return ResponseEntity.ok(borrowerService.getAll());
    }

    @PostMapping("/borrowers")
    public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower Borrower) {
        Borrower addedBorrower  = borrowerService.add(Borrower);
        return ResponseEntity.ok(addedBorrower);
    }

    @DeleteMapping("/borrowers/{id}")
    public ResponseEntity<HttpStatus> deleteBorrowerById(@PathVariable int id) {
        borrowerService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("borrowers{id}/borrow/{isbn}")
    public ResponseEntity<Optional<Borrower>> borrowBook(@PathVariable int id, @PathVariable String isbn){
        return ResponseEntity.ok(borrowBookService.borrowBook(id,isbn));
    }

}
