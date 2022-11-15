package com.academy.service;

import com.academy.model.Car;
import com.academy.repository.CarRepository;
import com.academy.web.dto.CarSaveDto;

import java.util.List;

public interface CarService {
    List<Car> getCars(String status);

    void saveNewCar(CarSaveDto carSaveDto);

}
