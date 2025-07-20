package com.popcorntech.app.core.service;

import com.popcorntech.app.core.util.TimerTask;
import jakarta.ejb.Timer;

public interface InterestTimerService {
    void doTask(TimerTask timerTask);

    void timeOut(Timer timer);
}
