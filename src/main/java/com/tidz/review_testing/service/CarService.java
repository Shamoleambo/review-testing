package com.tidz.review_testing.service;

import com.tidz.review_testing.exceptions.ResourceNotFoundError;
import com.tidz.review_testing.model.Car;
import com.tidz.review_testing.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundError("Could not find car with id " + id));
    }

    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) {
            throw new ResourceNotFoundError("Could not find all cars");
        } else {
            return cars;
        }
    }

    @Transactional
    public Car update(Long id, Car updatedCar) {
        throw new ResourceNotFoundError("Could not find car with id " + id);
    }
}
