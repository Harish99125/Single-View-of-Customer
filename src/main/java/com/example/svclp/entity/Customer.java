package com.example.svclp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;
    
    @Column(name = "First_Name", nullable = false)
    private String firstName;
    
    @Column(name = "Last_Name", nullable = false)
    private String lastName;
    
    @Column(name = "Email_ID", nullable = false, unique = true)
    private String emailId;
    
    @Column(name = "Mobile_Number", nullable = false, unique = true)
    private String mobileNumber;
    
    @Column(name = "Address", nullable = false)
    private String address;
    
    @Column(name = "PINCODE", nullable = false)
    private String pincode;
    
    @Column(name = "City", nullable = false)
    private String city;
    
    @Column(name = "Loyalty_Points")
	private Long loyaltyPoints = 150L;
    
    @Column(name = "PAN", nullable = false, unique = true)
    private String pan;
    
    @Column(name = "Aadhar", nullable = false, unique = true)
    private String aadhar;
    
    @Column(name = "Customer_Account_Number", nullable = false, unique = true)
    private Long customerAccountNumber;

	
    
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public Long getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(Long customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

	public void setLoyaltyPoints(long l) {
		
		
	}
}
