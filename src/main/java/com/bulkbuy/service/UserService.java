package com.bulkbuy.service;

import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.entity.VerificationEntity;
import com.bulkbuy.populator.UserEntityPopulator;
import com.bulkbuy.repository.UsersRepository;
import com.bulkbuy.request.form.UserRegistrationForm;
import com.bulkbuy.response.UserRegistrationProcessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class UserService {

    @Autowired
   private UsersRepository usersRepository;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserEntityPopulator userEntityPopulator;

    private static final String EMAIL_EXISTS =
            "Email already exists. Please use a different email or reset your password using 'Forgot Password'.";

    private static final String MOBILE_NUMBER_EXISTS =
            "Mobile number already exists. Please enter a different mobile number.";

    private static final String TOKEN_EXPIRED_CREATE_NEW =
            "The entered verification code has expired. A new verification code has been sent to your email. Please use the new one.";

    private static final String RESEND_ATTEMPTS_COMPLETED =
            "Daily resending verification code attempts limit reached. Please try again after the specified time.";

    private static final String VALIDATION_ATTEMPTS_COMPLETED =
            "Daily validating verification code attempts limit reached. Please try again after the specified time.";

    private static final String ATTEMPTS_REMAINED =
            "The same verification code has been resent to your email. You have remaining attempts, and the code is valid for the specified time.";

    private static final String VERIFICATION_CODE_SENT =
            "A new verification code has been sent successfully. You have remaining attempts, and the code is valid for the specified time.";

    private static final String INVALID_VERIFICATION_CODE =
            "Please enter valid verification code that sent to your email.";

    private static final String USER_CREATED =
            "User created successfully with the email.";

    public boolean isEmailIdRegistered(String emailId){
        return !usersRepository.existsByEmailId(emailId);
    }

    public Boolean isMobileNumberAvailable(String mobileNumber) {
        return !usersRepository.existsByMobileNumber(mobileNumber);
    }

    public UserRegistrationProcessResponseData sendEmailVerificationCode(String emailId) {

        VerificationEntity byMailId = verificationService.getByMailId(emailId);
        UserRegistrationProcessResponseData userRegistrationProcessResponseData = null;

        if (isEmailIdRegistered(emailId)) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER001", EMAIL_EXISTS, 0, 0,null, byMailId.getEmail(), null);
        } else if (!verificationService.isEmailVerificationCodeCreated(byMailId)) {
            byMailId = verificationService.createVerificationCodeForEmail(emailId);
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("SU001", VERIFICATION_CODE_SENT, byMailId.getResendAttemptsLeft(), byMailId.getVerificationAttemptsLeft() , byMailId.getValidUntil(), byMailId.getEmail(), null);
            emailService.sendVerificationEmail(byMailId);
        } else if (verificationService.isEmailVerificationCodeExpired(byMailId)) {
            byMailId = verificationService.extendVerificationCodeExpiryForEmail(byMailId);
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER003", TOKEN_EXPIRED_CREATE_NEW, byMailId.getResendAttemptsLeft(), byMailId.getVerificationAttemptsLeft() , byMailId.getValidUntil(), byMailId.getEmail(), null);
            emailService.sendVerificationEmail(byMailId);
        } else if (verificationService.hasExceededEmailVerificationCodeResendAttempts(byMailId)) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER002", RESEND_ATTEMPTS_COMPLETED, byMailId.getResendAttemptsLeft(), byMailId.getVerificationAttemptsLeft() , byMailId.getValidUntil(), byMailId.getEmail(), null);
        } else {
            byMailId = verificationService.reduceVerificationCodeSentAttemptsForEmail(byMailId);
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("SU002", ATTEMPTS_REMAINED, byMailId.getResendAttemptsLeft(), byMailId.getVerificationAttemptsLeft() , byMailId.getValidUntil(), byMailId.getEmail(), null);
            emailService.sendVerificationEmail(byMailId);
        }
        return userRegistrationProcessResponseData;
    }

    public UserRegistrationProcessResponseData registerUser(UserRegistrationForm userRegistrationForm) {

        VerificationEntity byMailId = verificationService.getByMailId(userRegistrationForm.getEmail());
        UserRegistrationProcessResponseData userRegistrationProcessResponseData = null;

        if (isMobileNumberAvailable(userRegistrationForm.getMobileNumber())) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER004", MOBILE_NUMBER_EXISTS, 0,0, null, userRegistrationForm.getEmail(), userRegistrationForm.getMobileNumber());
        } else if (isEmailIdRegistered(userRegistrationForm.getEmail())) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER001", EMAIL_EXISTS, 0,0, null, userRegistrationForm.getEmail(), userRegistrationForm.getMobileNumber());
        } else if (!verificationService.isEmailVerificationCodeCreated(byMailId)) {
            byMailId = verificationService.createVerificationCodeForEmail(userRegistrationForm.getEmail());
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("SU001", VERIFICATION_CODE_SENT, byMailId.getResendAttemptsLeft(), byMailId.getVerificationAttemptsLeft() , byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
            emailService.sendVerificationEmail(byMailId);
        } else if (verificationService.isEmailVerificationCodeExpired(byMailId)) {
            byMailId = verificationService.extendVerificationCodeExpiryForEmail(byMailId);
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER003", TOKEN_EXPIRED_CREATE_NEW, byMailId.getResendAttemptsLeft(),byMailId.getVerificationAttemptsLeft() ,  byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
            emailService.sendVerificationEmail(byMailId);
        } else if (verificationService.hasExceededEmailVerificationCodeResendAttempts(byMailId)) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER002", RESEND_ATTEMPTS_COMPLETED, byMailId.getResendAttemptsLeft(),byMailId.getVerificationAttemptsLeft() ,  byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
        } else if (verificationService.hasExceededEmailVerificationCodeValidationAttempts(byMailId)) {
            userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER005", VALIDATION_ATTEMPTS_COMPLETED, byMailId.getResendAttemptsLeft(),byMailId.getVerificationAttemptsLeft() ,  byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
        } else {
            if (Objects.equals(userRegistrationForm.getEmailVerificationCode(), byMailId.getVerificationCode())) {
                BulkBuyUserEntity bulkBuyUserEntity = userEntityPopulator.convertToEntity(userRegistrationForm);
                usersRepository.save(bulkBuyUserEntity);
                verificationService.removeVerificationCode(byMailId);
                userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("SU003", USER_CREATED, byMailId.getResendAttemptsLeft(),byMailId.getVerificationAttemptsLeft() ,  byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
            } else {
                byMailId = verificationService.reduceVerificationCodeValidationAttemptsForEmail(byMailId);
                userRegistrationProcessResponseData = new UserRegistrationProcessResponseData("ER006", INVALID_VERIFICATION_CODE, byMailId.getResendAttemptsLeft(),byMailId.getVerificationAttemptsLeft() ,  byMailId.getValidUntil(), byMailId.getEmail(), userRegistrationForm.getMobileNumber());
            }
        }
        return userRegistrationProcessResponseData;
    }

}
