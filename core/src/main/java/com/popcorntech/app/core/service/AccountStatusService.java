package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.AccountStatus;

import java.util.Optional;

public interface AccountStatusService {
    Optional<AccountStatus> findByName(String name);

    boolean existsAccountStatus(String name);
}
