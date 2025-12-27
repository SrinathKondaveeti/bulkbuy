package com.bulkbuy.service;

import com.bulkbuy.entity.AddressEntity;
import com.bulkbuy.populator.AddressEntityPopulator;
import com.bulkbuy.repository.AddressRepository;
import com.bulkbuy.request.form.AddressForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressEntityPopulator addressEntityPopulator;



    public AddressEntity createAddress(AddressForm addressForm){

        AddressEntity addressEntity = addressEntityPopulator.convertToEntity(addressForm);
        return addressRepository.save(addressEntity);

    }
}
