package com.academy.web.controller;

import com.academy.model.Car;
import com.academy.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping("")
    public List<Car> getCars() {
        return carService.getCarRepository().findAll();
    }

    @GetMapping("/id={id}")
    public Car getCar(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    @GetMapping("/status={status}")
    public List<Car> getCarsByStatus(@PathVariable String status) {
        return carService.getCarsByStatus(status);

    }

}
