package com.example.svclp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.svclp.entity.AccountDetails;
import com.example.svclp.entity.Customer;
import com.example.svclp.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/Customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        
        Long accountNumber = generateAccountNumber();
        
        
        customer.setCustomerAccountNumber(accountNumber);
        
       
        Customer createdCustomer = customerService.createCustomer(customer);

        
        String response = "Customer created successfully \n" +
                "Customer Name: " + createdCustomer.getFirstName() + "\n" +
                "Last Name: " + createdCustomer.getLastName() + "\n" +
                "Account Number: " + createdCustomer.getCustomerAccountNumber() + "\n" +
                "Card Number: " + generateCardNumber() + "\n" +
                "Loyalty Points Number: " + generatedLoyaltyPointsNumber();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    
    private Long generateAccountNumber() {
        
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
    
    private Long generateCardNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    private Long generatedLoyaltyPointsNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Customer> getCustomerByAccountNumber(@PathVariable Long accountNumber) {
        Customer customer = customerService.getCustomerByAccountNumber(accountNumber);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
