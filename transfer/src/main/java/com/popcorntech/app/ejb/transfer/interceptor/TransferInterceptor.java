package com.popcorntech.app.ejb.transfer.interceptor;

import com.popcorntech.app.ejb.transfer.annotation.Transfer;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Transfer
public class TransferInterceptor {


    @AroundInvoke
    public Object processTransfer(InvocationContext context) throws Exception {
        Transfer annotation = context.getMethod().getAnnotation(Transfer.class);

        try {
            return context.proceed();
        }catch(Exception e) {
            throw e;
        }

    }

    private void validateTransfer(Object[] parameters, Transfer annotation) {

    }

    private void handleTransferError(Exception e, Object[] parameters) {

    }

}
