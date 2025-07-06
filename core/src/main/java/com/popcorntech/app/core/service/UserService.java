package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    boolean existsUserByEmail(String email);
    Optional<User> addUser(User user);
    Optional<User> updateUser(User user);
    boolean existsUserByMobile(String mobileNumber);

}
