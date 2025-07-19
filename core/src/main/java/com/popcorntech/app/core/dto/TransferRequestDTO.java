package com.popcorntech.app.core.dto;

public class TransferRequestDTO {

    private Long fromAccount;
    private Long toAccount;
    private Double amount;
    private String holderName;
    private String reference;
    private String transferType;
    private String hash;

    public Long getFromAccount() {
        return fromAccount;
    }

    public TransferRequestDTO setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public TransferRequestDTO setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public Long getToAccount() {
        return toAccount;
    }

    public TransferRequestDTO setToAccount(Long toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public TransferRequestDTO setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getHolderName() {
        return holderName;
    }

    public TransferRequestDTO setHolderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public TransferRequestDTO setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getTransferType() {
        return transferType;
    }

    public TransferRequestDTO setTransferType(String transferType) {
        this.transferType = transferType;
        return this;
    }
}
