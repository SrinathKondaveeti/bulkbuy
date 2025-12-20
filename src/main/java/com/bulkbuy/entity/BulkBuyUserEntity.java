package com.bulkbuy.entity;

import com.bulkbuy.enums.UserTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "BulkBuyUsers")
public class BulkBuyUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String emailId;

    private String mobileNumber;

    private String password;

    private boolean isMailIdVerified;

    private UserTypeEnum userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMailIdVerified() {
        return isMailIdVerified;
    }

    public void setMailIdVerified(boolean mailIdVerified) {
        isMailIdVerified = mailIdVerified;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
}
