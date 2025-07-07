package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.AccountType;
import com.popcorntech.app.core.service.AccountTypeService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class AccountTypeSessionBean implements AccountTypeService {
    @Override
    public Optional<AccountType> findByName(String name) {
        try {

            switch (name) {
                case "SAVING_ACCOUNT":
                    return Optional.of(AccountType.SAVING_ACCOUNT);
                case "CHECKING_ACCOUNT":
                    return Optional.of(AccountType.CHECKING_ACCOUNT);
                case "BUSINESS_ACCOUNT":
                    return Optional.of(AccountType.BUSINESS_ACCOUNT);
                default:
                    return Optional.empty();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsAccountType(String name) {
        return findByName(name).isPresent();
    }
}
