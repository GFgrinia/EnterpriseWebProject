package com.academy.service.interfaces;

import com.academy.model.Car;
import com.academy.model.User;

import java.util.List;

public interface CarService {
    List<Car> getCars(String status, User user);

    void saveCar(Car car);

    Car getCarById(Integer id);

    void deleteCarById(Integer id);

}
