package com.bulkbuy.repository;

import com.bulkbuy.entity.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationEntity, Long> {

    public VerificationEntity findByEmail(String email);
    boolean existsByEmail(String emailId);

}
