package com.bulkbuy.request.form;

import org.springframework.web.multipart.MultipartFile;

public class VendorRegistrationForm extends UserRegistrationForm{

    private String companyName;
    private AddressForm companyAddress;
    private String companyDescription;
    private String productsDescription;
    private MultipartFile productCatalogueMedia;
    private String qualityAssuranceProcessDetails;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public AddressForm getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(AddressForm companyAddress) {
        this.companyAddress = companyAddress;
    }


    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getProductsDescription() {
        return productsDescription;
    }

    public void setProductsDescription(String productsDescription) {
        this.productsDescription = productsDescription;
    }

    public MultipartFile getProductCatalogueMedia() {
        return productCatalogueMedia;
    }

    public void setProductCatalogueMedia(MultipartFile productCatalogueMedia) {
        this.productCatalogueMedia = productCatalogueMedia;
    }

    public String getQualityAssuranceProcessDetails() {
        return qualityAssuranceProcessDetails;
    }

    public void setQualityAssuranceProcessDetails(String qualityAssuranceProcessDetails) {
        this.qualityAssuranceProcessDetails = qualityAssuranceProcessDetails;
    }
}
