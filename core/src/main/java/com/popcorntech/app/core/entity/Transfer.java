package com.popcorntech.app.core.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transfer")
@NamedQueries({
        @NamedQuery(name = "",query = "")
})
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private Date date;

    @JoinColumn(name = "from_account",nullable = false)
    @ManyToOne
    private BankAccount fromAccount;

    @JoinColumn(name = "to_account",nullable = false)
    @ManyToOne
    private BankAccount toAccount;

    @Column(name = "reference", nullable = false,length = 100)
    private String reference;

    @Enumerated(EnumType.STRING)
    @Column(name = "transfer_type",nullable = false)
    private TransferType transferType = TransferType.INTERNAL;

    @Enumerated(EnumType.STRING)
    @Column(name = "transfer_status", nullable = false)
    private TransferStatus status = TransferStatus.SUCCESS;

    public Transfer() {
    }

    public Long getId() {
        return id;
    }

    public Transfer setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Transfer setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Transfer setDate(Date date) {
        this.date = date;
        return this;
    }

    public BankAccount getFromAccount() {
        return fromAccount;
    }

    public Transfer setFromAccount(BankAccount fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public BankAccount getToAccount() {
        return toAccount;
    }

    public Transfer setToAccount(BankAccount toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Transfer setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public Transfer setTransferType(TransferType transferType) {
        this.transferType = transferType;
        return this;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public Transfer setStatus(TransferStatus status) {
        this.status = status;
        return this;
    }
}
