package com.popcorntech.app.core.dto;

public class TransferRequestDTO {

    private String fromAccount;
    private String toAccount;
    private String amount;
    private String holderName;
    private String reference;
    private String transferType;

    public String getFromAccount() {
        return fromAccount;
    }

    public TransferRequestDTO setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    public String getToAccount() {
        return toAccount;
    }

    public TransferRequestDTO setToAccount(String toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public TransferRequestDTO setAmount(String amount) {
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
