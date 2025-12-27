package com.bulkbuy.repository;

import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorEntity, Long> {
}
