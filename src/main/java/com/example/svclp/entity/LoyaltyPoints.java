package com.example.svclp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoyaltyPoints")
public class LoyaltyPoints {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "customer_account_number")
    private Long customerAccountNumber;
    
    @Column(name = "loyalty_points_number")
    private Long loyaltyPointsNumber;
    
    @Column(name = "loyalty_points")
    private Long loyaltyPoints;
    
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

	public void setCustomerLoyaltyPointsNumber(Object customerLoyaltyPointsNumber) {
		// TODO Auto-generated method stub
		
	}
}

