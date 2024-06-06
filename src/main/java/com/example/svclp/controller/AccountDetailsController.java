package com.example.svclp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.svclp.entity.AccountDetails;
import com.example.svclp.service.AccountDetailsService;

@RestController
@RequestMapping("/account-details")
public class AccountDetailsController {

    @Autowired
    private AccountDetailsService accountDetailsService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountDetails>> getAllAccountDetails() {
        List<AccountDetails> accountDetails = accountDetailsService.getAllAccountDetails();
        if (!accountDetails.isEmpty()) {
            return new ResponseEntity<>(accountDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDetails> getAccountDetailsByAccountNumber(@PathVariable Long accountNumber) {
        AccountDetails accountDetails = accountDetailsService.getAccountDetailsByAccountNumber(accountNumber);
        if (accountDetails != null) {
            return new ResponseEntity<>(accountDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


