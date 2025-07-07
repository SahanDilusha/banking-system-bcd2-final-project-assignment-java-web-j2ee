package com.popcorntech.app.ejb.user;

import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.UserService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Stateless
public class UserSessionBean implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> findUserById(Long id) {

        try {
            return Optional.ofNullable(em.find(User.class, id));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try {
            return Optional.ofNullable(em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).
                    getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsUserByEmail(String email) {
        try {
            return em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Optional<User> addUser(User user) {
        try {
            em.persist(user);
            em.flush();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> updateUser(User user) {
        try {
            em.merge(user);
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsUserByMobile(String mobileNumber) {
        try {
            return em.createNamedQuery("User.findByMobile", User.class).setParameter("mobile", mobileNumber).getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}
