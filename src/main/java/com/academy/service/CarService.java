package com.academy.service;

import com.academy.dto.CarDto;
import com.academy.dto.CarSaveDto;
import com.academy.model.Car;

import java.util.List;

public interface CarService {
    List<CarDto> getCars(String status);

    void saveNewCar(CarSaveDto carSaveDto);

    CarDto getCarById(Integer id);

    String deleteCar(Integer id);

}
