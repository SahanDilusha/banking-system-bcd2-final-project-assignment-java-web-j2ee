package com.popcorntech.app.ejb.transfer.validator;

import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.entity.TransferType;
import com.popcorntech.app.core.exception.InvalidTransferException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransferValidator {

    public TransferValidator(Transfer transfer) {
        validateTransfer(transfer);
    }
    
    private void validateTransfer(Transfer transfer) {
        if (transfer == null && transfer.getAmount() <= 0) {
            throw new InvalidTransferException("Amount must be greater than zero");
        }
    }

    private void validateTransferType(TransferType transferType) {

    }

}
