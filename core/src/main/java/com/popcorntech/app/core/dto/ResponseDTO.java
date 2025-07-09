package com.popcorntech.app.core.dto;

import com.popcorntech.app.core.entity.NotificationType;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private String message;

    private boolean status;

    private NotificationType type = NotificationType.INFORMATION;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public ResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseDTO setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public NotificationType getType() {
        return type;
    }

    public ResponseDTO setType(NotificationType type) {
        this.type = type;
        return this;
    }
}
