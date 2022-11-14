package com.academy.service;

import com.academy.model.Car;
import com.academy.repository.CarRepository;

import java.util.List;

public interface CarService {
    List<Car> getCars(String status);

    void saveCar(Car car);

}
