package com.popcorntech.app.core.dto;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable {
    private String password;
    private String email;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
