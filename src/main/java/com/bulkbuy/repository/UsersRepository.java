package com.bulkbuy.repository;


import com.bulkbuy.entity.BulkBuyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<BulkBuyUserEntity, Long> {

    boolean existsByEmailId(String emailId);
    boolean existsByMobileNumber(String mobileNumber);
    Optional<BulkBuyUserEntity> findByEmailId(String emailId);
    Optional<BulkBuyUserEntity> findByMobileNumber(String mobileNumber);


}
