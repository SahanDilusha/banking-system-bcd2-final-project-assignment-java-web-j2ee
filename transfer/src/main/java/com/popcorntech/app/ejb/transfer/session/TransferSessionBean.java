package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.ejb.transfer.annotation.BankTransfer;
import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.entity.TransferType;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.TransferService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Stateless
public class TransferSessionBean implements TransferService {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private BankAccountService bankAccountService;


    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Optional<Transfer> findById(Long id) {

        try {
            return Optional.ofNullable(em.find(Transfer.class, id));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @BankTransfer(type = TransferType.INTERNAL, maxAmount = 50000000.0)
    public Optional<Transfer> save(Transfer transfer) {

        try {
            em.persist(transfer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
