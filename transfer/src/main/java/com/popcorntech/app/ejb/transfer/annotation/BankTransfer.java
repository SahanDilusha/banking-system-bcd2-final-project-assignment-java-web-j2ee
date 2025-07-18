package com.popcorntech.app.ejb.transfer.annotation;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface BankTransfer {

    double maxAmount() default 500000.0;

}
