package com.bulkbuy.populator;

import com.bulkbuy.entity.AddressEntity;
import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.entity.VendorEntity;
import com.bulkbuy.entity.VerificationEntity;
import com.bulkbuy.enums.UserTypeEnum;
import com.bulkbuy.request.form.UserRegistrationForm;
import com.bulkbuy.request.form.VendorRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VendorEntityPopulator {

    @Autowired
    private AddressEntityPopulator addressEntityPopulator;

    public VendorEntity convertToEntity(VendorRegistrationForm vendorRegistrationForm) {

        VendorEntity vendorEntity = new VendorEntity();

        vendorEntity.setCompanyName(vendorRegistrationForm.getCompanyName());
        vendorEntity.setCompanyDescription(vendorRegistrationForm.getCompanyDescription());
        vendorEntity.setProductsDescription(vendorRegistrationForm.getProductsDescription());
        vendorEntity.setQualityAssuranceProcessDetails(vendorRegistrationForm.getQualityAssuranceProcessDetails());
        return vendorEntity;

    }


}
