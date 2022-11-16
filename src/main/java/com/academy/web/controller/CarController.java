package com.academy.web.controller;

import com.academy.model.CarStatus;
import com.academy.service.CarService;
import com.academy.dto.CarSaveDto;
import com.academy.dto.CarStatusDto;
import com.academy.mapper.CarStatusMapper;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    @GetMapping
    public String getCars(@RequestParam(required = false) String status, Model model) {
        var carsDto = carService.getCars(status);
        model.addAttribute("cars", carsDto);
        model.addAttribute("status", status);
        return "cars";
    }


    @GetMapping(value = "/{id}")
    public String getCar(@PathVariable Integer id, Model model) {
        var carDto = carService.getCarById(id);
        CarSaveDto carSaveDto = new CarSaveDto();
        model.addAttribute(carSaveDto);
        model.addAttribute("car", carDto);
        return "carDetails";
    }


    @PostMapping(value = "/cars")
    public String getCarsFilter(@ModelAttribute(value = "carStatusDto") CarStatusDto carStatusDto, Model model) {
        // TODO: 16.11.2022  path variable dont use this dto
        CarStatus carStatus = CarStatusMapper.INSTANCE.carStatusDtoToCarStatus(carStatusDto);
        var cars = carService.getCars(carStatus.getStatus());
        model.addAttribute("cars", cars);
        return "cars";
    }


    @GetMapping(value = "/addNewCar")
    public String addNewCar(Model model) {
        CarSaveDto carSaveDto = new CarSaveDto();
        model.addAttribute(carSaveDto);
        return "addNewCar";
    }


    @PostMapping(value = "/addNewCar")
    public String addCar(@ModelAttribute(value = "carSaveDto") CarSaveDto carSaveDto) {
        carService.saveNewCar(carSaveDto);
        return "redirect:/cars";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteCar(@PathVariable Integer id, Model model) {
        model.addAttribute("message", carService.deleteCar(id));
        return "carDetails";
    }

}
