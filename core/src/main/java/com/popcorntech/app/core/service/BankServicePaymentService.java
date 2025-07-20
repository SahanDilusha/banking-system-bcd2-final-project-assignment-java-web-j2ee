package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.BankServicePayment;

import java.util.List;
import java.util.Optional;

public interface BankServicePaymentService {
    Optional<BankServicePayment> findById(long id);
    Optional<BankServicePayment> save(BankServicePayment bankServicePayment);
    Optional<BankServicePayment> update(BankServicePayment bankServicePayment);
    List<BankServicePayment> findByUser(long userId);
}
