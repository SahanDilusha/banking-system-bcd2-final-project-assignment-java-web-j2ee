package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.Roles;

import java.util.Optional;

public interface RolesService {
    Optional<Roles> findByName(String name);

    boolean existsRoles(String name);
}
