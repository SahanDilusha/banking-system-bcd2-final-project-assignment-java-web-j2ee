package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.TransferType;

import java.util.Optional;

public interface TransferTypeService {
    boolean isTransferType(String transferType);
    Optional<TransferType> getTransferType(String transferType);
}
