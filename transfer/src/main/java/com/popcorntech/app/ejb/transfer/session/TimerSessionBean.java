package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.service.OTPTimerService;
import com.popcorntech.app.core.service.TransferService;
import com.popcorntech.app.core.util.TimerTask;
import com.popcorntech.app.core.util.ValidationUtil;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Stateless
public class TimerSessionBean implements OTPTimerService {

    @Resource
    private TimerService timerService;
    @EJB
    private TransferService transferService;

    @Override
    public TimerTask doTask(long time, TimerTask timerTask) {

        System.out.println("doTask");

        TimerConfig timerConfig = new TimerConfig();

        timerConfig.setPersistent(false);
        timerConfig.setInfo(timerTask);

        timerService.createSingleActionTimer(time, timerConfig);

        return timerTask;
    }

    @Override
    @Timeout
    public void timeOut(Timer timer) {
        TimerTask task = (TimerTask) timer.getInfo();

        if (task != null && transferService.isTransfer(task.getTaskId())) {
            transferService.update(transferService.findById(task.getTaskId()).get().setOtp(ValidationUtil.getInstance().passwordGenerator(6)));
            System.out.println("Transfer timed out");
        }

    }

    @Override
    public void cancel(String taskId) {
        for (Timer timer : timerService.getTimers()) {
            TimerTask task = (TimerTask) timer.getInfo();
            if (task != null && task.getTaskId().equals(taskId)) {
                timer.cancel();
                break;
            }
        }
    }
}
