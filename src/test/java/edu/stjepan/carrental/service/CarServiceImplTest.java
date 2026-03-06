package edu.stjepan.carrental.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.stjepan.carrental.dto.CarDTO;
import edu.stjepan.carrental.entity.Car;
import edu.stjepan.carrental.exception.ResourceNotFoundException;
import edu.stjepan.carrental.repository.CarRepository;
import edu.stjepan.carrental.service.impl.CarServiceImpl;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

  @Mock
  private CarRepository carRepository;

  @InjectMocks
  private CarServiceImpl carService;

  @Test
  void getCarById_WhenCarExists_ShouldReturnCarDTO() throws Exception {
    // Arrange
    Long carId = 1L;
    Car car = new Car("Toyota", "Corolla", "ABC-123", 2022, new BigDecimal("49.99"));
    Field idField = Car.class.getDeclaredField("id");
    idField.setAccessible(true);
    idField.set(car, carId);

    when(carRepository.findById(carId)).thenReturn(Optional.of(car));

    // Act
    CarDTO result = carService.getCarById(carId);

    // Assert
    assertNotNull(result);
    assertEquals(carId, result.getId());
    assertEquals("Toyota", result.getMake());
    assertEquals("Corolla", result.getModel());
    assertEquals("ABC-123", result.getRegistrationNumber());
    assertEquals(2022, result.getYear());
    assertEquals(new BigDecimal("49.99"), result.getDailyRate());
    assertEquals(0, result.getTotalBookings());

    verify(carRepository, times(1)).findById(carId);
  }

  @Test
  void getCarById_WhenCarDoesNotExist_ShouldThrowResourceNotFoundException() {
    // Arrange
    Long carId = 999L;
    when(carRepository.findById(carId)).thenReturn(Optional.empty());

    // Act & Assert
    ResourceNotFoundException exception = assertThrows(
        ResourceNotFoundException.class,
        () -> carService.getCarById(carId));

    assertEquals("Car not found with id: " + carId, exception.getMessage());

    verify(carRepository, times(1)).findById(carId);
  }
}
