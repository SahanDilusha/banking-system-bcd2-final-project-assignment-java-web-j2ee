package com.popcorntech.app.ejb.user;

import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.ActiveUserManagerService;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Stateful
public class ActiveUserManagerBean implements Serializable, ActiveUserManagerService {

    private final ConcurrentHashMap<String, User> session = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, User> getAll() {
        return session;
    }

    public void setSession(String sessionId, User user) {
        session.put(sessionId, user);
    }

    public void removeSession(String sessionId) {
        session.remove(sessionId);
    }

    public User getSession(String sessionId) {
        return session.get(sessionId);
    }


}
