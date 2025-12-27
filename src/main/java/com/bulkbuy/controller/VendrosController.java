package com.bulkbuy.controller;

import com.bulkbuy.request.form.ProductForm;
import com.bulkbuy.request.form.VendorRegistrationForm;
import com.bulkbuy.response.ProductData;
import com.bulkbuy.response.UserRegistrationProcessResponseData;
import com.bulkbuy.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendrosController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationProcessResponseData> createVendor(@RequestBody VendorRegistrationForm vendorRegistrationForm){

        return ResponseEntity.ok(vendorService.registerVendor(vendorRegistrationForm));
    }

}
