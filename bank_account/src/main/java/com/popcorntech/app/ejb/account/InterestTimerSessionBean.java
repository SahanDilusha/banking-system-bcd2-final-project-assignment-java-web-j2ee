package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.BankAccount;
import com.popcorntech.app.core.service.BankAccountService;
import com.popcorntech.app.core.service.InterestTimerService;
import com.popcorntech.app.core.util.TimerTask;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Stateless
public class InterestTimerSessionBean implements InterestTimerService {

    @Resource
    private TimerService timerService;
    @EJB
    private BankAccountService bankAccountService;

    @Override
    public void doTask(TimerTask timerTask) {
        System.out.println("doTask");
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setPersistent(false);
        timerConfig.setInfo(timerTask);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thirtyDaysLater = cal.getTime();

        timerService.createSingleActionTimer(thirtyDaysLater, timerConfig);

    }

    @Override
    @Timeout
    public void timeOut(Timer timer) {
        TimerTask task = (TimerTask) timer.getInfo();

        if (task != null) {

            Optional<BankAccount> bankAccount = bankAccountService.findAccountById(task.getTaskId());

            if (bankAccount.isPresent()) {
                if (bankAccount.get().getBalance() > 0) {
                    bankAccount.get().setBalance(bankAccount.get().getBalance() + (bankAccount.get().getBalance() * 5 / 100));
                    bankAccountService.updateAccount(bankAccount.get());
                }
            }

        }

    }
}
