package com.bulkbuy.populator;

import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.enums.UserTypeEnum;
import com.bulkbuy.request.form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserEntityPopulator {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BulkBuyUserEntity convertToEntity(UserRegistrationForm userRegistrationForm) {

        BulkBuyUserEntity bulkBuyUserEntity = new BulkBuyUserEntity();
        bulkBuyUserEntity.setName(userRegistrationForm.getName());
        bulkBuyUserEntity.setEmailId(userRegistrationForm.getEmail());
        bulkBuyUserEntity.setMobileNumber(userRegistrationForm.getMobileNumber());
        bulkBuyUserEntity.setMailIdVerified(true);
        bulkBuyUserEntity.setPassword(passwordEncoder.encode(userRegistrationForm.getPassword()));
        bulkBuyUserEntity.setUserType(UserTypeEnum.CUSTOMER);
        return bulkBuyUserEntity;

    }


}
