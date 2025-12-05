package com.bulkbuy.service;

import com.bulkbuy.entity.ProductEntity;
import com.bulkbuy.populator.ProductEntityPopulator;
import com.bulkbuy.repository.ProductsRepository;
import com.bulkbuy.request.form.ProductForm;
import com.bulkbuy.response.ProductData;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductEntityPopulator productEntityPopulator;

    public List<ProductData> getAllProducts() {

        List<ProductEntity> all = productsRepository.findAll();

        return all.stream()
                .map(productEntityPopulator::convertToData)
                .collect(Collectors.toList());
    }

    public List<ProductData> createProducts(List<ProductForm> productsListForm) {

        List<ProductEntity> productEntities = productsRepository.saveAll(productsListForm.stream()
                .map(productEntityPopulator::convertToEntity)
                .collect(Collectors.toList()));

        return productEntities.stream()
                .map(productEntityPopulator::convertToData)
                .collect(Collectors.toList());
    }
}
