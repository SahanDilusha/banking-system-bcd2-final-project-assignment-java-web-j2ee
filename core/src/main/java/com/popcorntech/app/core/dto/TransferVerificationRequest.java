package com.popcorntech.app.core.dto;

public class TransferVerificationRequest {

    private String otp;
    private String hashedPassword;

    public TransferVerificationRequest() {
    }

    public TransferVerificationRequest(String otp, String hashedPassword) {}

    public String getOtp() {
        return otp;
    }

    public TransferVerificationRequest setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public TransferVerificationRequest setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }
}
