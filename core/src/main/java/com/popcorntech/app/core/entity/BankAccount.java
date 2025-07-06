package com.popcorntech.app.core.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_account")
@NamedQueries({
        @NamedQuery(name = "BankAccount.findAccountByEmail",query = "SELECT a FROM BankAccount a WHERE a.user.email = :email"),
        @NamedQuery(name = "BankAccount.findAccountByUser",query = "SELECT a FROM BankAccount a WHERE a.user = :user")
})
public class BankAccount {
    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false)
    private AccountStatus status = AccountStatus.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.SAVING_ACCOUNT;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BankAccount() {
    }

    public BankAccount(Long accountNumber, Double balance, AccountStatus status, User user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = status;
        this.user = user;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BankAccount setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public BankAccount setBalance(Double balance) {
        this.balance = balance;
        return this;
    }


}
