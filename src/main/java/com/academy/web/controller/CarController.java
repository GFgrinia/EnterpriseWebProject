package com.academy.web.controller;

import com.academy.constant.CarStatuses;
import com.academy.model.Car;
import com.academy.model.CarStatus;
import com.academy.service.CarService;
import com.academy.service.CarStatusService;
import com.academy.web.dto.CarDto;
import com.academy.web.dto.CarStatusDto;
import com.academy.web.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarStatusService carStatusService;

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(required = false) String status, Model model) {
        var cars = carService.getCars(status);
        model.addAttribute("cars", cars);
        return "cars";
    }


    @GetMapping(value = "/addCar")
    public String addCar(Model model) {
        CarDto carDto = new CarDto();
        CarStatusDto carStatusDto = new CarStatusDto();
        model.addAttribute(carDto);
        model.addAttribute(carStatusDto);
        return "addCar";
    }

    @PostMapping(value = "/addCar")
    public String addCar(@RequestParam String vendor,
                         @RequestParam String model,
                         @RequestParam Integer rent) {

        Car car = Car.builder().vendor(vendor)
                .model(model)
                .rent(rent)
                .carStatus(carStatusService.findByStatus(CarStatuses.FREE.label))
                .build();

        carService.saveCar(car);


        return "redirect:/cars";
    }


    @GetMapping(value = "/oldcars")
    @ResponseBody
    public List<Car> getCarList() {
        return carService.getCars(null);
    }

}
