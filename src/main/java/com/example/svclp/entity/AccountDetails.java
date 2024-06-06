package com.example.svclp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AccountDetails")
public class AccountDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "customer_account_number")
    private Long customerAccountNumber;
    
    @Column(name = "loyalty_points_number")
    private Long loyaltyPointsNumber;
    
    @Column(name = "loyalty_points")
    private Long loyaltyPoints;
    
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "aadhar")
    private String aadhar;
    
    @Column(name = "card_number")
    private String cardNumber;

    
    public AccountDetails() {
    }

    public AccountDetails(Long customerAccountNumber, Long loyaltyPointsNumber, Long loyaltyPoints,  String firstName, String lastName, String aadhar, String cardNumber) {
        this.customerAccountNumber = customerAccountNumber;
        this.loyaltyPointsNumber = loyaltyPointsNumber;
        this.loyaltyPoints = loyaltyPoints;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aadhar = aadhar;
        this.cardNumber = cardNumber;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(Long customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public Long getLoyaltyPointsNumber() {
        return loyaltyPointsNumber;
    }

    public void setLoyaltyPointsNumber(Long loyaltyPointsNumber) {
        this.loyaltyPointsNumber = loyaltyPointsNumber;
    }

    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
