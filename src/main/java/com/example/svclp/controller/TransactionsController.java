package com.example.svclp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.svclp.entity.Transactions;
import com.example.svclp.entity.AccountDetails;
import com.example.svclp.service.TransactionsService;
import com.example.svclp.service.AccountDetailsService;

import java.util.List;

@RestController
@RequestMapping("/transactions") 
public class TransactionsController {
    
    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private AccountDetailsService accountDetailsService;
    
    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        Transactions savedTransaction = transactionsService.saveTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<Transactions>> getTransactionsByAccountNumber(@PathVariable Long accountNumber) {
        List<Transactions> transactions = transactionsService.getTransactionsByAccountNumber(accountNumber);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

  
}
