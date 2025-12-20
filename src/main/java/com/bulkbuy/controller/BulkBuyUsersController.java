package com.bulkbuy.controller;

import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.request.EmailVerificationRequest;
import com.bulkbuy.request.MobileNumberVerificationRequest;
import com.bulkbuy.request.form.UserRegistrationForm;
import com.bulkbuy.response.UserRegistrationProcessResponseData;
import com.bulkbuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BulkBuyUsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/sendEmailVerificationCode")
    public ResponseEntity<UserRegistrationProcessResponseData> sendEmailVerificationCode(@RequestBody EmailVerificationRequest emailId) {
        return ResponseEntity.ok(userService.sendEmailVerificationCode(emailId.getEmailId()));
    }

    @PostMapping("/isEmailAvailable")
    public ResponseEntity<Boolean> isEmailIdRegistered(@RequestBody EmailVerificationRequest emailId) {
        return ResponseEntity.ok(userService.isEmailIdRegistered(emailId.getEmailId()));
    }

    @PostMapping("/isMobileNumberAvailable")
    public ResponseEntity<Boolean> isEmailAvailable(@RequestBody MobileNumberVerificationRequest mobileNumber) {
        return ResponseEntity.ok(userService.isMobileNumberAvailable(mobileNumber.getMobileNumber()));
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationProcessResponseData> registerUser(@RequestBody UserRegistrationForm userRegistrationForm) {
        return ResponseEntity.ok(userService.registerUser(userRegistrationForm));
    }


}
