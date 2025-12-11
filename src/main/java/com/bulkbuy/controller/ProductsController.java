package com.bulkbuy.controller;

import com.bulkbuy.request.form.ProductForm;
import com.bulkbuy.response.ProductData;
import com.bulkbuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "https://srinathkondaveeti.github.io")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductData>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("/create")
    public ResponseEntity<List<ProductData>> createProduct(@RequestBody List<ProductForm> productsListForm){
        return ResponseEntity.ok(productService.createProducts(productsListForm));
    }

}
