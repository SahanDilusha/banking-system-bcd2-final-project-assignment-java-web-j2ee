package com.popcorntech.app.ejb.transfer;

import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.service.TransferService;

import java.util.Optional;

public class TransferSessionBean implements TransferService {
    @Override
    public Optional<Transfer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Transfer> save(Transfer transfer) {
        return Optional.empty();
    }
}
