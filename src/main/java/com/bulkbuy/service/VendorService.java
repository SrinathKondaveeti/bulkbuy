package com.bulkbuy.service;

import com.bulkbuy.entity.AddressEntity;
import com.bulkbuy.entity.VendorEntity;
import com.bulkbuy.populator.VendorEntityPopulator;
import com.bulkbuy.repository.VendorRepository;
import com.bulkbuy.request.form.VendorRegistrationForm;
import com.bulkbuy.response.UserRegistrationProcessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class VendorService {

    @Autowired
    private UserService userService;

    @Autowired
    private VendorEntityPopulator vendorEntityPopulator;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private AddressService addressService;



    @Transactional
    public UserRegistrationProcessResponseData registerVendor(VendorRegistrationForm vendorRegistrationForm) {


        UserRegistrationProcessResponseData userRegistrationProcessResponseData = userService.registerVendorUser(vendorRegistrationForm);

        if(userRegistrationProcessResponseData.getStatusCode().equalsIgnoreCase("SU003")){

            AddressEntity address = addressService.createAddress(vendorRegistrationForm.getCompanyAddress());
            VendorEntity vendorEntity = vendorEntityPopulator.convertToEntity(vendorRegistrationForm);
            ArrayList<AddressEntity> addressEntities = new ArrayList<>();
            addressEntities.add(address);
            vendorEntity.setCompanyAddress(addressEntities);
            vendorEntity.setBulkBuyUserEntity(userService.getUserByEmail(userRegistrationProcessResponseData.getEmail()));
            vendorRepository.save(vendorEntity);
        }

        return userRegistrationProcessResponseData;
    }
}
