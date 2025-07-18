package com.popcorntech.app.ejb.transfer.interceptor;

import com.popcorntech.app.core.dto.TransferRequestDTO;
import com.popcorntech.app.core.exception.InvalidTransferException;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.TransferTypeService;
import com.popcorntech.app.ejb.transfer.annotation.BankTransfer;
import jakarta.annotation.Priority;
import jakarta.ejb.TimerService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@BankTransfer
@Priority(1)
public class TransferInterceptor {

    @Inject
    private BankAccountService bankAccountService;
    @Inject
    private TransferTypeService transferTypeService;

    @AroundInvoke
    public Object processTransfer(InvocationContext context) throws Exception {

        System.out.println("Transfer invoked");

        try {

            BankTransfer annotation = context.getMethod().getAnnotation(BankTransfer.class);

            TransferRequestDTO requestDTO = null;

            for (Object arg : context.getParameters()) {
                if (arg instanceof TransferRequestDTO) {
                    requestDTO = (TransferRequestDTO) arg;
                    break;
                }
            }

            if (requestDTO == null) {
                throw new InvalidTransferException("No transfer object found");
            }

            if (requestDTO.getFromAccount() == null || requestDTO.getToAccount() == null || requestDTO.getAmount() == null) {
                throw new InvalidTransferException("Invalid request");
            }

            if (requestDTO.getFromAccount() < 0 || requestDTO.getToAccount() < 0) {
                throw new InvalidTransferException("Invalid request");
            }

            if (requestDTO.getFromAccount().equals(requestDTO.getToAccount())) {
                throw new InvalidTransferException("Transfer failed");
            }

            if (!bankAccountService.existsAccountById(requestDTO.getFromAccount()) || !bankAccountService.existsAccountById(requestDTO.getToAccount())) {
                throw new InvalidTransferException("Transfer failed");
            }

            if (requestDTO.getAmount() <= 0 || requestDTO.getAmount() > annotation.maxAmount() || bankAccountService.checkBalance(requestDTO.getFromAccount(), requestDTO.getAmount())) {
                throw new InvalidTransferException("Invalid amount");
            }

            if (!transferTypeService.isTransferType(requestDTO.getTransferType())) {
                throw new InvalidTransferException("Invalid transfer type");
            }

            return context.proceed();
        } catch (Exception e) {
            throw e;
        }

    }

}
