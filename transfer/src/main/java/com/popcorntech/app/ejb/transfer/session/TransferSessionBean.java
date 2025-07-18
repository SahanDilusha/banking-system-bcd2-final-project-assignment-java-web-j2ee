package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.dto.TransferRequestDTO;
import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.entity.TransferStatus;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.TransferService;
import com.popcorntech.app.core.service.TransferTypeService;
import com.popcorntech.app.ejb.transfer.annotation.BankTransfer;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.Optional;

@Stateless
public class TransferSessionBean implements TransferService {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private BankAccountService bankAccountService;

    @EJB
    private TransferTypeService transferTypeService;

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
    @BankTransfer
    public Optional<Transfer> save(TransferRequestDTO requestDTO) {

        try {

            Transfer transfer = new Transfer().setAmount(requestDTO.getAmount()).setDate(new Date()).
                    setFromAccount(bankAccountService.findAccountById(requestDTO.getFromAccount()).get())
                    .setToAccount(bankAccountService.findAccountById(requestDTO.getToAccount()).get()).setReference(requestDTO.getReference())
                    .setTransferType(transferTypeService.getTransferType(requestDTO.getTransferType()).get())
                    .setStatus(TransferStatus.FAILURE);

            em.persist(transfer);
            em.flush();
            return Optional.of(transfer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
