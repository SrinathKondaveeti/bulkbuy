package com.bulkbuy.populator;

import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.enums.UserTypeEnum;
import com.bulkbuy.request.form.UserRegistrationForm;
import org.springframework.stereotype.Component;

@Component
public class UserEntityPopulator {

    public BulkBuyUserEntity convertToEntity(UserRegistrationForm userRegistrationForm) {

        BulkBuyUserEntity bulkBuyUserEntity = new BulkBuyUserEntity();
        bulkBuyUserEntity.setName(userRegistrationForm.getName());
        bulkBuyUserEntity.setEmailId(userRegistrationForm.getEmail());
        bulkBuyUserEntity.setMobileNumber(userRegistrationForm.getMobileNumber());
        bulkBuyUserEntity.setMailIdVerified(true);
        bulkBuyUserEntity.setPassword(userRegistrationForm.getPassword());
        bulkBuyUserEntity.setUserType(UserTypeEnum.CUSTOMER);
        return bulkBuyUserEntity;

    }


}
