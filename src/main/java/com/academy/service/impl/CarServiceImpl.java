package com.academy.service.impl;

import com.academy.constant.CarStatuses;
import com.academy.constant.UserRole;
import com.academy.model.Car;
import com.academy.model.User;
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
    public List<Car> getCars(String status, User user) {
        String defaultStatus = CarStatuses.FREE.label;

        if (user != null) {
            String currentUserRoleName = user.getUserRole().getRoleName();

            if (currentUserRoleName.equals(UserRole.ROLE_ADMIN.roleName)) {
                return status != null ? carRepository.findCarsByStatus(status) : carRepository.findAll();
            } else {
                return carRepository.findCarsByStatus(defaultStatus);
            }

        } else {
            return carRepository.findCarsByStatus(defaultStatus);
        }
    }


    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }


    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElseThrow();
    }


    @Override
    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }
}
