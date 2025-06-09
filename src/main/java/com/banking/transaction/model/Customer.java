package com.banking.transaction.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer") // Optional: You can specify the table name here
public class Customer {

    @Id
    @Column(name ="customer_id")
    private String customerId;
    
    @Column(name ="first_name")
    private String firstName;
    
    @Column(name ="last_name")
    private String lastName;
    @Column(name ="email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    
    @Column(name ="zip_code")
    private String zipCode;
    @Column(name ="country")
    private String country;
    
    // Getters and Setters
    public Customer() {
		super();
	}
    public Customer(String customerId, String firstName, String lastName, String email, String phone, String accountId,
			String street, String city, String state, String zipCode, String country) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.accountId = accountId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	

	public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
