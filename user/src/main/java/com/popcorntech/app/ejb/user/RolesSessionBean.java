package com.popcorntech.app.ejb.user;

import com.popcorntech.app.core.entity.Roles;
import com.popcorntech.app.core.service.RolesService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class RolesSessionBean implements RolesService {
    @Override
    public Optional<Roles> findByName(String name) {
        try {
            switch (name) {
                case "ADMIN":
                    return Optional.of(Roles.ADMIN);
                case "USER":
                    return Optional.of(Roles.USER);
                default:
                    return Optional.empty();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsRoles(String name) {
        return findByName(name).isPresent();
    }
}
