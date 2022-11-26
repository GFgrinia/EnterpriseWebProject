package com.academy.web.controller;

import com.academy.constant.MessageManager;
import com.academy.model.User;
import com.academy.service.interfaces.CarService;
import com.academy.service.interfaces.CarStatusService;
import com.academy.web.dto.CarDto;
import com.academy.web.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;
    private final CarStatusService carStatusService;
    private final CarMapper carMapper;

    @GetMapping
    public String getCars(@RequestParam(required = false) String status, @RequestParam(required = false) String message, Model model) {
        var cars = carService.getCars(status);
        var carsDto = carMapper.map(cars);
        model.addAttribute("cars", carsDto);
        model.addAttribute("message", message);
        return "cars";
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("#user.userRole.accessLevel >= T(com.academy.constant.UserRole).ROLE_ADMIN.accessLevel")
    public String getCar(@PathVariable Integer id, Model model, User user) {
        var car = carService.getCarById(id);
        CarDto carDto = carMapper.carToCarDto(car);

        CarDto carForm = new CarDto();
        model.addAttribute(carForm);
        model.addAttribute("car", carDto);
        return "carDetails";
    }


    @GetMapping(value = "/carNew")
    public String addNewCar(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute(carDto);
        return "carNew";
    }


    @PostMapping(value = "/carNew")
    public ModelAndView addCar(@ModelAttribute(value = "carSaveDto") CarDto carDto, ModelMap model) {
        var car = carMapper.carDtoToCar(carDto);
        car.setCarStatus(carStatusService.findByStatus(carDto.getStatus()));
        carService.saveCar(car);
        model.addAttribute("message", MessageManager.ADD_CAR_SUCCESS.label);
        return new ModelAndView("redirect:/cars", model);
    }



    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteCar(@PathVariable Integer id, ModelMap model) {
        carService.deleteCarById(id);
        model.addAttribute("message", MessageManager.DELETE_SUCCESS.label);
        return new ModelAndView("redirect:/cars", model);
    }

}
