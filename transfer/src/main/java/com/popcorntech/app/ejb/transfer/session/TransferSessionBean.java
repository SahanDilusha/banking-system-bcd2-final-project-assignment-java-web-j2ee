package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.dto.TransferRequestDTO;
import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.entity.TransferStatus;
import com.popcorntech.app.core.exception.InvalidTransferException;
import com.popcorntech.app.core.mail.OTPMail;
import com.popcorntech.app.core.provider.MailServiceProvider;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.OTPTimerService;
import com.popcorntech.app.core.service.TransferService;
import com.popcorntech.app.core.service.TransferTypeService;
import com.popcorntech.app.core.util.TimerTask;
import com.popcorntech.app.core.util.ValidationUtil;
import com.popcorntech.app.ejb.transfer.annotation.BankTransfer;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.Date;
import java.util.Optional;

@Stateless
public class TransferSessionBean implements TransferService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @EJB
    private BankAccountService bankAccountService;

    @EJB
    private TransferTypeService transferTypeService;

    @EJB
    private OTPTimerService otpTimerService;

    @Override
    public boolean isTransfer(long id) {
        return findById(id).isPresent();
    }

    @Override
    public Optional<Transfer> update(Transfer transfer) {
        try {
            em.merge(transfer);
            return Optional.ofNullable(transfer);
        } catch (Exception e) {
            throw new InvalidTransferException("Invalid transfer request");
        }
    }

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
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @BankTransfer(maxAmount = 500000.0)
    public Optional<Transfer> save(TransferRequestDTO requestDTO) {

        try {

            String otp = ValidationUtil.getInstance().passwordGenerator(6);

            Transfer transfer = new Transfer().setAmount(requestDTO.getAmount()).setDate(new Date()).setFromAccount(bankAccountService.findAccountById(requestDTO.getFromAccount()).get()).setToAccount(bankAccountService.findAccountById(requestDTO.getToAccount()).get()).setReference(requestDTO.getReference()).setTransferType(transferTypeService.getTransferType(requestDTO.getTransferType()).get()).setStatus(TransferStatus.FAILURE).setOtp(otp);

            utx.begin();

            em.persist(transfer);
            em.flush();

            utx.commit();


            otpTimerService.doTask(180000L, new TimerTask(transfer.getId(), ""));

            OTPMail otpMail = new OTPMail("sdilusha34@gmail.com", otp);

            MailServiceProvider.getInstance().sendMail(otpMail);

            return Optional.of(transfer);

        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            throw new InvalidTransferException("Invalid transfer request");
        }

    }
}
