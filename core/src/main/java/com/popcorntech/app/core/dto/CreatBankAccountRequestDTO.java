package com.popcorntech.app.core.dto;

public class CreatBankAccountRequestDTO {

    private String email;

    private String password;

    private String otp;

    private String firstName;

    private String lastName;

    private String mobile;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private String idNO;

    private Double deposit;

    private String accountType;

    private String idType;

    public CreatBankAccountRequestDTO() {
    }

    public String getEmail() {
        return email;
    }

    public CreatBankAccountRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreatBankAccountRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getOtp() {
        return otp;
    }

    public CreatBankAccountRequestDTO setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreatBankAccountRequestDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreatBankAccountRequestDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public CreatBankAccountRequestDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public CreatBankAccountRequestDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CreatBankAccountRequestDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public CreatBankAccountRequestDTO setState(String state) {
        this.state = state;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CreatBankAccountRequestDTO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getIdNO() {
        return idNO;
    }

    public CreatBankAccountRequestDTO setIdNO(String idNO) {
        this.idNO = idNO;
        return this;
    }

    public Double getDeposit() {
        return deposit;
    }

    public CreatBankAccountRequestDTO setDeposit(Double deposit) {
        this.deposit = deposit;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public CreatBankAccountRequestDTO setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getIdType() {
        return idType;
    }

    public CreatBankAccountRequestDTO setIdType(String idType) {
        this.idType = idType;
        return this;
    }
}
