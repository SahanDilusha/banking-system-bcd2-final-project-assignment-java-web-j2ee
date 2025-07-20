package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.BankAccount;
import com.popcorntech.app.core.entity.BankServicePayment;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.BankServicePaymentService;
import jakarta.ejb.EJB;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.util.Date;
import java.util.List;

@Singleton
@Startup
public class PaymentCollectionSession {

    @EJB
    private BankAccountService bankAccountService;
    @EJB
    private BankServicePaymentService bankServicePaymentService;


    @Schedule(year = "*", month = "*", dayOfMonth = "30", hour = "1", minute = "0")
    public void collectCharges() {
        System.out.println("Collecting  service charges...");

        List<BankAccount> accounts = bankAccountService.findAllAccounts();

        for (BankAccount account : accounts) {

            if (bankServicePaymentService.save(new BankServicePayment()
                    .setBankAccount(account).setAmount(account.getBalance() - account.getBalance()).setDate(new Date())).isPresent()) {
                bankAccountService.updateAccount(account.setBalance(account.getBalance() > 0 && account.getBalance() > 700 ? account.getBalance() - 700 : 0));
            }

        }

    }

}
