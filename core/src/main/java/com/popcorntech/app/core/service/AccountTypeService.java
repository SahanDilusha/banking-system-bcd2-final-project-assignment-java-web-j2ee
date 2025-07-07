package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.AccountType;

import java.util.Optional;

public interface AccountTypeService {
    Optional<AccountType> findByName(String name);
    boolean existsAccountType(String name);
}
