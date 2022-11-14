package com.academy.service.impl;

import com.academy.model.Car;
import com.academy.repository.CarRepository;
import com.academy.service.CarService;
import com.academy.service.CarStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    private final CarStatusService carStatusService;

    @Override
    public List<Car> getCars(String status) {
        if (status != null) {
            return carRepository.findCarsByStatus(status);
        } else {
            return carRepository.findAll();
        }
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }


}
