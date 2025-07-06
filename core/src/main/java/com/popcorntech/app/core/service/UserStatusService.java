package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.UserStatus;

import java.util.Optional;

public interface UserStatusService {

    Optional<UserStatus> findByName(String name);

    boolean existsUserStatus(String name);

}
