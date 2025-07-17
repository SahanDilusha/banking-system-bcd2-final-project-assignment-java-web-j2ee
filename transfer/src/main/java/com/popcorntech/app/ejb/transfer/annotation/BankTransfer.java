package com.popcorntech.app.ejb.transfer.annotation;

import com.popcorntech.app.core.entity.TransferType;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BankTransfer {

    TransferType type() default TransferType.INTERNAL;

    double maxAmount() default 100000.0;

    boolean requiresApproval() default false;

    String allowedRoles() default "";

}
