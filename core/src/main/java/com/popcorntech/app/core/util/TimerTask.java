package com.popcorntech.app.core.util;

import java.io.Serializable;

public class TimerTask implements Serializable {

    private final Long taskId;
    private final String taskName;

    public TimerTask(Long taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }
}
