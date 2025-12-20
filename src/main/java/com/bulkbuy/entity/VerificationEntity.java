package com.bulkbuy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "verifications")
public class VerificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    private String verificationCode;

    private String email;

    private int resendAttemptsLeft;

    private int verificationAttemptsLeft;

    private LocalDateTime validUntil;

    public int getVerificationAttemptsLeft() {
        return verificationAttemptsLeft;
    }

    public void setVerificationAttemptsLeft(int verificationAttemptsLeft) {
        this.verificationAttemptsLeft = verificationAttemptsLeft;
    }

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getResendAttemptsLeft() {
        return resendAttemptsLeft;
    }

    public void setResendAttemptsLeft(int resendAttemptsLeft) {
        this.resendAttemptsLeft = resendAttemptsLeft;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }
}
