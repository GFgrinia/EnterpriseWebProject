package com.academy.service.impl;

import com.academy.model.Car;
import com.academy.repository.CarRepository;
import com.academy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    @Override
    public CarRepository getCarRepository() {
        return carRepository;
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getCarsByStatus(String status) {
        return carRepository.findCarsByStatus(status);
    }

}
