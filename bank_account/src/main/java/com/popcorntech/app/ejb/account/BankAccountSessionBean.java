package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.BankAccount;
import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.BankAccountService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class BankAccountSessionBean implements BankAccountService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean checkBalance(Long accountNo, Double amount) {
        try {

            if (existsAccountById(accountNo)) {
                if (findAccountById(accountNo).get().getBalance() < amount) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<BankAccount> findAccountById(Long id) {

        try {
            return Optional.ofNullable(em.find(BankAccount.class, id));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public List<BankAccount> findAccountByEmail(String email) {
        return em.createNamedQuery("BankAccount.findAccountByEmail", BankAccount.class).setParameter("email", email).getResultList();
    }

    @Override
    public boolean existsAccountById(Long id) {

        try {
            return em.find(BankAccount.class, id) != null;
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<BankAccount> findAccountByUser(User user) {
        return em.createNamedQuery("BankAccount.findAccountByUser", BankAccount.class).setParameter("user", user).getResultList();
    }

    @Override
    public Optional<BankAccount> createAccount(BankAccount account) {
        try {
            em.persist(account);
            return Optional.of(account);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<BankAccount> updateAccount(BankAccount account) {

        try {
            em.merge(account);
            return Optional.of(account);
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
