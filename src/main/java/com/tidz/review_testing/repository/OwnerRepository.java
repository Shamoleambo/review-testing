package com.tidz.review_testing.repository;

import com.tidz.review_testing.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
