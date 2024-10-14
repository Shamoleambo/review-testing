package com.tidz.review_testing.service;

import com.tidz.review_testing.model.Car;
import com.tidz.review_testing.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public Car save(Car car) {
        return carRepository.save(car);
    }
}
