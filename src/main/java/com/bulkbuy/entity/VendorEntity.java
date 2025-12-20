package com.bulkbuy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String companyName;

    //private AddressEntity companyAddress;


}
