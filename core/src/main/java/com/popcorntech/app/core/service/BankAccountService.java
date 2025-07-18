package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.BankAccount;
import com.popcorntech.app.core.entity.User;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {

    Optional<BankAccount> findAccountById(Long id);

    List<BankAccount> findAccountByEmail(String email);

    boolean existsAccountById(Long id);

    List<BankAccount> findAccountByUser(User user);

    Optional<BankAccount> createAccount(BankAccount account);

    Optional<BankAccount> updateAccount(BankAccount account);

    boolean checkBalance(Long accountNo, Double amount);

}
