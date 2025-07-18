package com.popcorntech.app.core.service;

import com.popcorntech.app.core.util.TimerTask;
import jakarta.ejb.Timer;

public interface OTPTimerService {

    TimerTask doTask(long time,TimerTask timerTask);

    void timeOut(Timer timer);

    void cancel(String taskId);
}
