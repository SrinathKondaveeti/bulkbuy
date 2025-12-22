package com.bulkbuy.request.form;

public class UserLoginForm {

    private String emailOrMobileNumber;
    private String Password;

    public String getEmailOrMobileNumber() {
        return emailOrMobileNumber;
    }

    public void setEmailOrMobileNumber(String emailOrMobileNumber) {
        this.emailOrMobileNumber = emailOrMobileNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
