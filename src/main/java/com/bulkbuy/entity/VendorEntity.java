package com.bulkbuy.entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table(name = "vendors")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    @Column(nullable = false)
    private String companyName;

    private String companyDescription;

    private String productsDescription;

    //private MultipartFile productCatalogueMedia;

    private String qualityAssuranceProcessDetails;

    @OneToOne
    private BulkBuyUserEntity bulkBuyUserEntity;

    @OneToMany
    @JoinTable(
            name = "vendor_addresses",
            joinColumns = @JoinColumn(name = "vendor_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<AddressEntity> companyAddress;

    public Long getVendorId() {
        return vendorId;
    }

    public BulkBuyUserEntity getBulkBuyUserEntity() {
        return bulkBuyUserEntity;
    }

    public void setBulkBuyUserEntity(BulkBuyUserEntity bulkBuyUserEntity) {
        this.bulkBuyUserEntity = bulkBuyUserEntity;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getQualityAssuranceProcessDetails() {
        return qualityAssuranceProcessDetails;
    }

    public void setQualityAssuranceProcessDetails(String qualityAssuranceProcessDetails) {
        this.qualityAssuranceProcessDetails = qualityAssuranceProcessDetails;
    }

    public List<AddressEntity> getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(List<AddressEntity> companyAddress) {
        this.companyAddress = companyAddress;
    }
}
