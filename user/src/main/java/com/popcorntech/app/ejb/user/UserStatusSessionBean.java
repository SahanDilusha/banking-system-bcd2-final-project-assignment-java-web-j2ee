package com.popcorntech.app.ejb.user;

import com.popcorntech.app.core.entity.UserStatus;
import com.popcorntech.app.core.service.UserStatusService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class UserStatusSessionBean implements UserStatusService {
    @Override
    public Optional<UserStatus> findByName(String name) {

        try {

            switch (name) {
                case "ACTIVE":
                    return Optional.of(UserStatus.ACTIVE);
                case "NOT_VERIFIED":
                    return Optional.of(UserStatus.NOT_VERIFIED);
                case "INACTIVE":
                    return Optional.of(UserStatus.INACTIVE);
                case "DELETED":
                    return Optional.of(UserStatus.DELETED);
                case "DEACTIVATED":
                    return Optional.of(UserStatus.DEACTIVATED);
                default:
                    return Optional.empty();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public boolean existsUserStatus(String name) {
        return findByName(name).isPresent();
    }
}
