package com.popcorntech.app.core.dto;

import java.io.Serializable;

public class UserRegisterRequestDTO implements Serializable {

    private String email;
    private String password;
    private Long accountNumber;

    public UserRegisterRequestDTO() {
    }

    public UserRegisterRequestDTO(String email, String password, Long accountNumber) {
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public UserRegisterRequestDTO setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }
}
