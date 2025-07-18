package com.popcorntech.app.core.service;

import com.popcorntech.app.core.dto.TransferRequestDTO;
import com.popcorntech.app.core.entity.Transfer;

import java.util.Optional;

public interface TransferService {
    Optional<Transfer> findById(Long id);

    Optional<Transfer> save(TransferRequestDTO requestDTO);

    Optional<Transfer> update(Transfer transfer );

    boolean isTransfer(long  id);

}
