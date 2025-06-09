package com.banking.transaction.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;
    
    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "amount")
    private double amount;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "currency")
    private String currency;
    
    // Getters and Setters

    public Transactions() {
		super();
	}
    
    public Transactions(String transactionId, String accountId, LocalDate date, String type, double amount, String description, String currency) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.currency = currency;
    }

	public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
