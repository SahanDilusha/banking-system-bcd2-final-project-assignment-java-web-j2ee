package com.popcorntech.app.core.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private String message;

    private boolean status;

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
}
