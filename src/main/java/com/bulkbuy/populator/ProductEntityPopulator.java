package com.bulkbuy.populator;

import com.bulkbuy.entity.ProductEntity;
import com.bulkbuy.entity.ProductMedia;
import com.bulkbuy.request.form.ProductForm;
import com.bulkbuy.response.ProductData;
import com.bulkbuy.response.ProductMediaData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductEntityPopulator {

    public ProductData convertToData(ProductEntity productEntity) {

        ProductData productData = new ProductData();
        productData.setProductId(productEntity.getProductId());
        productData.setName(productEntity.getName());
        productData.setDescription(productEntity.getDescription());
        productData.setOrdersRequired(productEntity.getOrdersRequired());
        productData.setOrdersPlaced(productEntity.getOrdersPlaced());
        productData.setOrderCutOffDate(productEntity.getOrderCutOffDate());
        productData.setActualPrice(productEntity.getActualPrice());
        productData.setOfferPrice(productEntity.getOfferPrice());
        productData.setProductLiveTime(productEntity.getProductLiveTime());
        productData.setInterestedPeopleCount((productEntity.getInterestedPeopleCount() != null) ?productEntity.getInterestedPeopleCount().intValue():0);

        if (productEntity.getProductMedia() != null) {

            ProductMediaData productMediaData = new ProductMediaData();
            productMediaData.setLogo(productEntity.getProductMedia().getLogo());
            productMediaData.setImages(productEntity.getProductMedia().getImages());
            productMediaData.setVideos(productEntity.getProductMedia().getVideos());
            productMediaData.setGif(productEntity.getProductMedia().getGif());

            productData.setProductMediaData(productMediaData);
        }

        return productData;

    }

    public ProductEntity convertToEntity(ProductForm productForm) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productForm.getProductId());
        productEntity.setName(productForm.getName());
        productEntity.setDescription(productForm.getDescription());
        productEntity.setOrdersRequired(productForm.getOrdersRequired());
        productEntity.setOrdersPlaced(productForm.getOrdersPlaced());
        productEntity.setOrderCutOffDate(productForm.getOrderCutOffDate());
        productEntity.setActualPrice(productForm.getActualPrice());
        productEntity.setOfferPrice(productForm.getOfferPrice());
        productEntity.setProductLiveTime(productForm.getProductLiveTime());
        productEntity.setInterestedPeopleCount(productForm.getInterestedPeopleCount());

        if (productForm.getProductMediaData() != null) {

            ProductMedia productMedia = new ProductMedia();
            productMedia.setLogo(productForm.getProductMediaData().getLogo());
            productMedia.setImages(productForm.getProductMediaData().getImages());
            productMedia.setVideos(productForm.getProductMediaData().getVideos());
            productMedia.setGif(productForm.getProductMediaData().getGif());

            productEntity.setProductMedia(productMedia);
        }
        return productEntity;

    }

}
