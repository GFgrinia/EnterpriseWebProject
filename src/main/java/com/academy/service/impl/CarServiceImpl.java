package com.academy.service.impl;

import com.academy.model.Car;
import com.academy.repository.CarRepository;
import com.academy.service.interfaces.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    @Override
    public List<Car> getCars(String status) {
        return status != null ? carRepository.findCarsByStatus(status) : carRepository.findAll();
    }


    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }


    @Override
    public Car getCarById(Integer id) {
        // TODO: 18.11.2022 Optional check with exception
        return carRepository.findById(id).get();
    }


    @Override
    public void deleteCarById(Integer id) {
        // TODO: 18.11.2022  Exception with illegal id
        carRepository.deleteById(id);
    }


}
