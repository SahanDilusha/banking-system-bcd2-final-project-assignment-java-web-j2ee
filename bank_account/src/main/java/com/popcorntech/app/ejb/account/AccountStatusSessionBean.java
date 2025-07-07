package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.AccountStatus;
import com.popcorntech.app.core.service.AccountStatusService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class AccountStatusSessionBean implements AccountStatusService {
    @Override
    public Optional<AccountStatus> findByName(String name) {

        try {

            switch (name) {
                case "ACTIVE":
                    return Optional.of(AccountStatus.ACTIVE);
                case "DEACTIVATED":
                    return Optional.of(AccountStatus.DEACTIVATED);
                case "CLOSED":
                    return Optional.of(AccountStatus.CLOSED);
                default:
                    return Optional.empty();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public boolean existsAccountStatus(String name) {
        return findByName(name).isPresent();
    }
}
