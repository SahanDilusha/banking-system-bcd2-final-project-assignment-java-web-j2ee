package com.popcorntech.app.ejb.transfer.interceptor;

import com.popcorntech.app.ejb.transfer.annotation.BankTransfer;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@BankTransfer
public class TransferInterceptor {

    @AroundInvoke
    public Object processTransfer(InvocationContext context) throws Exception {
        try{
            return context.proceed();
        }catch(Exception e){
            throw e;
        }

    }

}
