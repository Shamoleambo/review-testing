package com.tidz.review_testing.service;

import com.tidz.review_testing.exceptions.ResourceNotFoundError;
import com.tidz.review_testing.model.Car;
import com.tidz.review_testing.model.CarType;
import com.tidz.review_testing.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;
import java.util.Optional;

@SpringBootTest
public class CarServiceTest {

    @InjectMocks
    private CarService service;

    @Mock
    private CarRepository repository;

    //There was a function over here that initialized the mocks before each test
    @BeforeEach
    public void setMocks() {
        MockitoAnnotations.openMocks(repository);
    }

    @Test
    public void methodSaveShouldReturnACar() {
        //Arrange
        Car car = new Car(CarType.SEDAN, "Civic", Year.of(1994));

        //Act
        Mockito.when(repository.save(Mockito.any(Car.class))).thenReturn(car);
        Car savedCar = service.save(car);

        //Assert
        Assertions.assertEquals(savedCar.getType(), CarType.SEDAN);
        Assertions.assertEquals(savedCar.getName(), "Civic");
        Assertions.assertEquals(savedCar.getYear(), Year.of(1994));

        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Car.class));
    }

    @Test
    public void methodGetCarByIdShouldThrowIfCarIsNotFound() {
        // Arrange

        // Act
        Mockito.when(repository.findById(Mockito.anyLong())).thenThrow(new ResourceNotFoundError("Could not find car"));

        // Assert
        Assertions.assertThrows(ResourceNotFoundError.class, () -> service.getCarById(Mockito.anyLong()));
    }

    @Test
    public void methodGetCarByIdShouldReturnACar() {
        // Arrange
        Car car = new Car(CarType.WAGON, "Audi RS4", Year.of(1996));

        // Act
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(car));
        Car returnedCar = service.getCarById(Mockito.anyLong());

        // Assert
        Assertions.assertEquals(returnedCar.getType(), CarType.WAGON);
        Assertions.assertEquals(returnedCar.getName(), "Audi RS4");
        Assertions.assertEquals(returnedCar.getYear(), Year.of(1996));
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
    }
}
