package com.popcorntech.app.ejb.user;

import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.UserService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Stateless
public class UserSessionBean implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> getUser(Long id) {
        System.out.println("getUser Ok... Id -" + id);
        try {
            return Optional.of(em.find(User.class, id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
