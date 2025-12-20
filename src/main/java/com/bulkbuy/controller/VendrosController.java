package com.bulkbuy.controller;

import com.bulkbuy.request.form.ProductForm;
import com.bulkbuy.response.ProductData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendrosController {

    @PostMapping("/create")
    public ResponseEntity<String> createVendor(@RequestBody List<ProductForm> productsListForm){
        return ResponseEntity.ok("");
    }

}
