package com.bulkbuy.controller;

import com.bulkbuy.response.ProductData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductData>> getAllProducts() {

        return ResponseEntity.ok(null);
    }

}
