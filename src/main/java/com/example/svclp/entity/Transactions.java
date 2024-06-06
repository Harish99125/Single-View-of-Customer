package com.example.svclp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "account_number_from")
    private Long accountNumberFrom;

    @Column(name = "account_number_to")
    private Long accountNumberTo;

    @Column(name = "loyalty_points_credit_to")
    private Long loyaltyPointsCreditTo;

    @Column(name = "loyalty_points_debit_from")
    private Long loyaltyPointsDebitFrom;

    @Column(name = "transaction_amount")
    private Long transactionAmount;

    @Column(name = "loyalty_points")
    private Long loyaltyPoints;

    @Column(name = "loyalty_points_type")
    private String loyaltyPointsType;
    
	   Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(Long accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public Long getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(Long accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public Long getLoyaltyPointsCreditTo() {
        return loyaltyPointsCreditTo;
    }

    public void setLoyaltyPointsCreditTo(Long loyaltyPointsCreditTo) {
        this.loyaltyPointsCreditTo = loyaltyPointsCreditTo;
    }

    public Long getLoyaltyPointsDebitFrom() {
        return loyaltyPointsDebitFrom;
    }

    public void setLoyaltyPointsDebitFrom(Long loyaltyPointsDebitFrom) {
        this.loyaltyPointsDebitFrom = loyaltyPointsDebitFrom;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getLoyaltyPointsType() {
        return loyaltyPointsType;
    }

    public void setLoyaltyPointsType(String loyaltyPointsType) {
        this.loyaltyPointsType = loyaltyPointsType;
    }


    public void calculateLoyaltyPoints() {
        if ("Card".equalsIgnoreCase(transactionType)) {
            loyaltyPoints = (long) (transactionAmount * 0.05);
        } else if ("Loyalty Deposits".equalsIgnoreCase(transactionType)) {
            loyaltyPoints = (long) (transactionAmount * 0.10);
        } else {
            loyaltyPoints = 0L;
        }
    }
}

