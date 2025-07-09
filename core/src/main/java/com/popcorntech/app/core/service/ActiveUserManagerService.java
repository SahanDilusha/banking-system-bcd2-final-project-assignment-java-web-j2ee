package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.User;

import java.util.concurrent.ConcurrentHashMap;

public interface ActiveUserManagerService {
    ConcurrentHashMap<String, User> getAll();

    void setSession(String sessionId, User user);

    void removeSession(String sessionId);

    User getSession(String sessionId);
}
