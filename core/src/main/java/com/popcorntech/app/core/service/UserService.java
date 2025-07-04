package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

}
