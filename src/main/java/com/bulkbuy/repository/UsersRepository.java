package com.bulkbuy.repository;


import com.bulkbuy.entity.BulkBuyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<BulkBuyUserEntity, Long> {

    boolean existsByEmailId(String emailId);
    boolean existsByMobileNumber(String mobileNumber);
}
