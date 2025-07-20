package com.popcorntech.app.core.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bank_account")
public class BankServicePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "bank_account", nullable = false)
    @ManyToOne
    private BankAccount bankAccount;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private Date date;

    public Date getDate() {
        return date;
    }

    public BankServicePayment setDate(Date date) {
        this.date = date;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BankServicePayment setId(Long id) {
        this.id = id;
        return this;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public BankServicePayment setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public BankServicePayment setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
