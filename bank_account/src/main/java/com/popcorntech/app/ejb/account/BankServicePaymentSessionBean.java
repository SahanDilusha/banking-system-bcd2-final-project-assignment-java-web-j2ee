package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.BankServicePayment;
import com.popcorntech.app.core.service.BankServicePaymentService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class BankServicePaymentSessionBean implements BankServicePaymentService {


    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<BankServicePayment> findById(long id) {
        try {
            return Optional.ofNullable(em.find(BankServicePayment.class, id));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<BankServicePayment> save(BankServicePayment bankServicePayment) {
        try {

            em.persist(bankServicePayment);
            em.flush();

            return Optional.ofNullable(em.merge(bankServicePayment));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<BankServicePayment> update(BankServicePayment bankServicePayment) {
        return Optional.empty();
    }

    @Override
    public List<BankServicePayment> findByUser(long userId) {
        return List.of();
    }
}
