package com.bulkbuy.service;

import com.bulkbuy.entity.VerificationEntity;
import com.bulkbuy.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationService {

    @Autowired
    private VerificationRepository verificationRepository;

    public VerificationEntity getByMailId(String email){
     return verificationRepository.findByEmail(email);
    }

    public void removeVerificationCode(VerificationEntity verificationEntity) {
        verificationRepository.delete(verificationEntity);
    }

    public VerificationEntity createVerificationCodeForEmail(String email){
        VerificationEntity verificationEntity = new VerificationEntity();
        verificationEntity.setVerificationCode("999999");
        verificationEntity.setEmail(email);
        verificationEntity.setResendAttemptsLeft(4);
        verificationEntity.setVerificationAttemptsLeft(4);
        verificationEntity.setValidUntil(LocalDateTime.now().plusMinutes(10));
        return verificationRepository.save(verificationEntity);
    }

    public VerificationEntity reduceVerificationCodeSentAttemptsForEmail(VerificationEntity byEmail) {
        byEmail.setResendAttemptsLeft(byEmail.getResendAttemptsLeft()-1);
        return verificationRepository.save(byEmail);
    }

    public VerificationEntity reduceVerificationCodeValidationAttemptsForEmail(VerificationEntity byEmail) {
        byEmail.setVerificationAttemptsLeft(byEmail.getVerificationAttemptsLeft()-1);
        return verificationRepository.save(byEmail);
    }

    public boolean isVerificationCodeAvailableForEmail(String emailId) {
      return verificationRepository.existsByEmail(emailId);
    }

    public boolean isVerificationCodeExpiredForEmail(String emailId) {
        VerificationEntity byEmail = verificationRepository.findByEmail(emailId);
        return byEmail == null || byEmail.getValidUntil().isBefore(LocalDateTime.now());

    }

    public VerificationEntity extendVerificationCodeExpiryForEmail(VerificationEntity byMailId) {
        byMailId.setResendAttemptsLeft(5);
        byMailId.setVerificationAttemptsLeft(5);
        byMailId.setValidUntil(LocalDateTime.now().plusMinutes(10));
        return verificationRepository.save(byMailId);
    }

    public boolean isEmailVerificationCodeCreated(VerificationEntity byMailId){
        return byMailId != null;
    }

    public boolean isEmailVerificationCodeExpired(VerificationEntity byMailId){
        return byMailId == null || byMailId.getValidUntil().isBefore(LocalDateTime.now());
    }

    public boolean hasExceededEmailVerificationCodeResendAttempts(VerificationEntity byMailId){
        return byMailId == null || byMailId.getResendAttemptsLeft() <= 0;
    }

    public boolean hasExceededEmailVerificationCodeValidationAttempts(VerificationEntity byMailId){
        return byMailId == null || byMailId.getVerificationAttemptsLeft() <= 0;
    }

}
