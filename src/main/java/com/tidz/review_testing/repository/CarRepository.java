package com.tidz.review_testing.repository;

import com.tidz.review_testing.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
