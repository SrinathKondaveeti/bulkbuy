package com.bulkbuy.populator;

import com.bulkbuy.entity.AddressEntity;
import com.bulkbuy.request.form.AddressForm;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityPopulator {

    public AddressForm convertToData(AddressEntity addressEntity) {

        return null;

    }

    public AddressEntity convertToEntity(AddressForm addressForm) {

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setDoorNumber(addressForm.getDoorNumber());
        addressEntity.setBuildName(addressForm.getBuildName());
        addressEntity.setStreetName(addressForm.getStreetName());
        addressEntity.setLandMark(addressForm.getLandMark());
        addressEntity.setAreaName(addressForm.getAreaName());
        addressEntity.setCity(addressForm.getCity());
        addressEntity.setDistrict(addressForm.getDistrict());
        addressEntity.setPinCode(addressForm.getPinCode());
        addressEntity.setState(addressForm.getState());
        addressEntity.setCountry(addressForm.getCountry());

        return addressEntity;

    }

}
