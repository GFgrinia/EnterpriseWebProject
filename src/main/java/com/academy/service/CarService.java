package com.academy.service;

import com.academy.model.Car;
import com.academy.repository.CarRepository;

import java.util.List;

public interface CarService {
    CarRepository getCarRepository();

    Car getCarById(Integer id);

    List<Car> getCarsByStatus(String status);
}
