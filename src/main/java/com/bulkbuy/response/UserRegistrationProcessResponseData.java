package com.bulkbuy.response;

import java.time.LocalDateTime;

public class UserRegistrationProcessResponseData {

    private String statusCode;
    private String statusDescription;
    private int resendAttemptsLeft;
    private int verificationAttemptsLeft;
    private LocalDateTime validTill;
    private String email;
    private String mobileNumber;

    public UserRegistrationProcessResponseData(String statusCode, String statusDescription, int resendAttemptsLeft, int verificationAttemptsLeft, LocalDateTime validTill, String email, String mobileNumber){

        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.resendAttemptsLeft = resendAttemptsLeft;
        this.verificationAttemptsLeft = verificationAttemptsLeft;
        this.validTill = validTill;
        this.email = email;
        this.mobileNumber = mobileNumber;

    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getResendAttemptsLeft() {
        return resendAttemptsLeft;
    }

    public void setResendAttemptsLeft(int resendAttemptsLeft) {
        this.resendAttemptsLeft = resendAttemptsLeft;
    }

    public int getVerificationAttemptsLeft() {
        return verificationAttemptsLeft;
    }

    public void setVerificationAttemptsLeft(int verificationAttemptsLeft) {
        this.verificationAttemptsLeft = verificationAttemptsLeft;
    }

    public LocalDateTime getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDateTime validTill) {
        this.validTill = validTill;
    }
}
